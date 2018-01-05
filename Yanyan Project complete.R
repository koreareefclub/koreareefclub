Diabetes<- read.csv("Diabetes.Data.Set.csv",header = 1)
View(Diabetes)

##############################################################################################
#################################### logistic regression #####################################
##############################################################################################

Dia<-Diabetes[,-c(21,22,23,24,25,26,27)]
View(Dia)
attach(Dia)
as.factor(Quality)->Quality
as.factor(Abnormality)->Abnormality
as.factor(Classification)->Classification
as.factor(Label)->Label

set.seed(2)
Dia.train = sample(1:nrow(Dia), 800)
Dia.test=Dia[-Dia.train,]
Dia.test

####################################   Not Scaled   ##########################################

###### full logistic regression: with all variables
log.ful<- glm(Classification~.,family=binomial,data=Dia, subset=Dia.train)
summary(log.ful)
## P value for results.5, exludates.1 and label is lower than 5%, others are not


###### Thus run regression with only these three variables
log.ful.3 <- glm(Classification~Results.5+Exludates.1+Label,family=binomial,data=Dia,subset=Dia.train)
summary(log.ful.3)
## P value for Label is biggher than 5%. We should get rid of it.


###### Thus run regression with only these two variables
log.ful.2 <- glm(Classification~Results.5+Exludates.1,family=binomial,data=Dia,subset=Dia.train)
summary(log.ful.2)
## we get pretty good model, but the p value for intercept is bigger than 5%, thus is not important.

###### Prediction Accuracy
prob <- predict(log.ful.2, Dia.test, type = "response")
Dia.pred <-rep(0, length(prob))
Dia.pred[prob > 0.5] <- 1
table(Dia.pred, Dia.test$Classification)
(199+56)/(199+56+63+33)
mean(Dia.pred == Dia.test$Classification)

####################################     Scaled      ##########################################

####### then we try to scale all non numerical variables to see whether the results differs

results.s.1<-scale(Results.1)
results.s.2<-scale(Results.2)
results.s.3<-scale(Results.3)
results.s.4<-scale(Results.4)
results.s.5<-scale(Results.5)
results.s.6<-scale(Results.6)
exludates.s.1<-scale(Exludates.1)
exludates.s.2<-scale(Exludates.2)
exludates.s.3<-scale(Exludates.3)
exludates.s.4<-scale(Exludates.4)
exludates.s.5<-scale(Exludates.5)
exludates.s.6<-scale(Exludates.6)
exludates.s.7<-scale(Exludates.7)
exludates.s.8<-scale(Exludates.8)
distance.s<-scale(Distance)
diameter.s<-scale(Diameter)

Dia.s<-data.frame(Dia,results.s.1,results.s.2,results.s.3,results.s.4,results.s.5,results.s.6,exludates.s.1,exludates.s.2,exludates.s.3,exludates.s.4,exludates.s.5,exludates.s.6,exludates.s.7,exludates.s.8)
set.seed(2)
Dia.train.s = sample(1:nrow(Dia.s), 800)
Dia.test.s=Dia.s[-Dia.train.s,]
Dia.test.s

log.ful.s <- glm(Classification~Quality+results.s.1+results.s.2+results.s.3+results.s.4+results.s.5+results.s.6+exludates.s.1+exludates.s.2+exludates.s.3+exludates.s.4+exludates.s.5+exludates.s.6+exludates.s.7+exludates.s.8+Diameter+Label,family=binomial,data=Dia.s, subset=Dia.train.s)
summary(log.ful.s)
## we get similar result


###### Again we take only these variables with stars for P value
log.ful.s.n <- glm(Classification~Quality+results.s.5+exludates.s.1+Diameter+Label,family=binomial,data=Dia.s, subset=Dia.train.s)
summary(log.ful.s.n)
## only scaled Quality, results.5 and exludates.1 matter


###### So run the regression with only these three
log.ful.s.3 <- glm(Classification~Quality+results.s.5+exludates.s.1,family=binomial,data=Dia.s, subset=Dia.train.s)
summary(log.ful.s.3)
## P value for Quality is biggher than 5%


###### Prediction Accuracy
prob.3 <- predict(log.ful.s.3, Dia.test.s, type = "response")
Dia.pred.3 <-rep(0, length(prob.3))
Dia.pred.3[prob > 0.5] <- 1
table(Dia.pred.3, Dia.test.s$Classification)
(199+56)/(199+56+63+33)
mean(Dia.pred.3 == Dia.test.s$Classification)


###### So run the regression with only two
log.ful.s.2 <- glm(Classification~results.s.5+exludates.s.1,family=binomial,data=Dia.s, subset=Dia.train.s)
summary(log.ful.s.2)
## we get a better model, with all coefficient are significant different from 0.

###### Prediction Accuracy
prob.2 <- predict(log.ful.s.2, Dia.test.s, type = "response")
Dia.pred.2 <-rep(0, length(prob.2))
Dia.pred.2[prob > 0.5] <- 1
table(Dia.pred.2, Dia.test.s$Classification)
(199+56)/(199+56+63+33)
mean(Dia.pred.2 == Dia.test.s$Classification)

## Scaled model with 3 or 2 variable provide excatly the same prediction accuracy as unscaled model


###### choose same confidence level data
#confidence level =0.9, so choose the fifth collumn for 2-7 and 8-15 variable

#logistic regression for scaled variables
log.0.9.s = glm(Classification~Quality + Abnormality+results.s.5+exludates.s.5+distance.s+diameter.s+Label, family=binomial,data=Dia, subset=Dia.train)
summary(log.0.9.s)
#logistic regression for not scaled variables
log.0.9 = glm(Classification~Quality + Abnormality+Results.5+Exludates.5+Distance+Diameter+Label, family=binomial,data=Dia, subset=Dia.train)
summary(log.0.9)
## For both models, only the "result" variable matters.


##############################################################################################
#####################################   Decision Tree   ######################################
##############################################################################################
library(tree)

Q =ifelse(Quality <=0, "No", "Yes")
A =ifelse(Abnormality <=0, "No", "Yes")
C = ifelse(Classification <=0, "No", "Yes")
L = ifelse(Label<=0, "No", "Yes")
Dia.tree = data.frame(Dia,Q,A,C,L)
View(Dia.tree)

Dia.t <- Dia.tree[,-c(1,2,19,20)]
View(Dia.t)
attach(Dia.t)

set.seed(1)
train = sample(1:nrow(Dia.t), 800)
Dia.t.test=Dia.t[-train,]
Dia.t.test

###### Tree with all

Tree.ful <- tree(C~.,data = Dia.t,subset=train)
summary(Tree.ful)

plot(Tree.ful)
text(Tree.ful,pretty=1)

tree.full.pred = predict(Tree.ful, Dia.t.test, type="class")
table(tree.full.pred, Dia.t.test$C)                     
(202+58)/(202+58+26+65)

mean(tree.full.pred == Dia.t.test$C)

###### Tree with result.5 and exludate.1
Tree<-tree(C~Results.5+Exludates.1+Diameter+Distance+Q+A+L,data = Dia.t,subset=train)
summary(Tree)

plot(Tree)
text(Tree,pretty=1)

tree.pred = predict(Tree, Dia.t.test, type="class")
table(tree.pred, Dia.t.test$C)
(177+90)/(177+33+90+51)

mean(tree.pred == Dia.t.test$C)

###### Tree with same confidence level : result.5 and exludate.5
Tree.5<-tree(C~Results.5+Exludates.5+Diameter+Distance+Q+A+L,data = Dia.t,subset=train)
summary(Tree.5)

plot(Tree.5)
text(Tree.5,pretty=1)

tree.pred.5 = predict(Tree.5, Dia.t.test, type="class")
table(tree.pred.5, Dia.t.test$C)
(160+91)/(160+32+68+91)

mean(tree.pred.5 == Dia.t.test$C)
