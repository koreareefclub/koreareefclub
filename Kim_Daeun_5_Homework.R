#2. This question should be answered using the Weekly data set, which is part of the ISLR
#package. This data is similar in nature to the Smarket data, except that it contains 1,089
#weekly returns for 21 years, from the beginning of 1990 to the end of 2010.
write.csv(Smarket, file="Smarket.csv",row.names=F)
################################################

library(ISLR)
attach(Smarket)
data(Smarket)
View(Smarket)
?Smarket

levels(Smarket$Direction)
class(Smarket$Direction)
class(Smarket$Today)

################ read.csv to load data
read.csv("Smarket.csv") ->my.smarket
View(my.smarket)
#####################################

head(Smarket)
tail(Smarket)
names(Smarket)
summary(Smarket)

cor(Smarket)
cor(Smarket[,-9])
length(Smarket)
length(Smarket$Year)
Smarket[,-seq(2:10)]->xx
head(xx)
Smarket[,-seq(2:5)]->xx
head(xx)

#### plots
plot(Smarket)
plot(Smarket$Today~Smarket$Lag1)
plot(Smarket$Lag1,Smarket$Today)
hist(Smarket$Today)
hist(Smarket$Today,breaks=5)
hist(Today,breaks=5)
hist(Today,breaks=10)
hist(Today,breaks=100)

#### logistic regression
class(Smarket$Direction)
levels(Smarket$Direction)

class(Smarket$Today)

glm.fit=glm(Direction~Lag1 + Lag2 + Lag3 + Lag4 + Lag5 + Volume,
            family=binomial,data=Smarket)
summary(glm.fit)

predict(glm.fit,type="response")
predict(glm.fit,type="response")->glm.probs
options("digits"=2)
glm.probs[1:5]
contrasts(Direction) ## check dummy variable: 1 or 0

glm.pred=rep("Down",1250)
glm.pred[glm.probs>.5]="Up"
head(glm.pred)
head(Direction)
table(glm.pred,Direction)
(145+507)/1250
mean(glm.pred==Direction)

levels(Smarket$Year)
class(Smarket$Year)
summary(Smarket$Year)

attach(Smarket)
train=(Year<2005)
head(train)

Smarket.2005=Smarket[!train,]

dim(Smarket.2005)
Direction.2005=Direction[!train]
View(Smarket.2005)

head(Direction.2005)
length(Direction.2005)
glm.fit=glm(Direction~Lag1 + Lag2 + Lag3 + Lag4 + Lag5 + Volume,
            family=binomial,data=Smarket,subset=train)
summary(glm.fit)
glm.probs=predict(glm.fit,newdata=Smarket.2005,type="response")
glm.probs

glm.pred=rep("Down",252)
glm.pred[glm.probs>.5]="Up"
glm.pred

table(glm.pred,Direction.2005)
mean(glm.pred==Direction.2005) #True is 1, False is 0 so this depicts accuracy

glm.fit=glm(Direction~Lag1 + Lag2,family=binomial,data=Smarket,subset=train)
summary(glm.fit)

# improve prediction accuracy
glm.fit=glm(Direction ~ Lag1+Lag2, data=Smarket, family=binomial,subset=train)
glm.probs=predict(glm.fit,Smarket.2005,type="response")
glm.pred=rep("Down",252)
glm.pred[glm.probs>.5]="Up"
glm.pred

table(glm.pred,Direction.2005) #Diagonal ones are correct predictions
mean(glm.pred==Direction.2005) #=(35+106)/(35+35+76+106)
#(a) Produce some numerical and graphical summaries of the Weekly data. Do there appear
#to be any patterns?

library(ISLR)
attach(Smarket)
data(Smarket)
attach(Weekly)
summary(Weekly)
cor(Weekly[, -9])
plot(Volume)


#(b) Use the full data set to perform a logistic regression with Direction as the response
#and the _ve lag variables plus Volume as predictors. Use the summary function to print
#the results. Do any of the predictors appear to be statistically signi_cant? If so, which
#ones?
fit.glm <- glm(Direction ~ Lag1 + Lag2 + Lag3 + Lag4 + Lag5 + Volume, data = Weekly, family = binomial)
summary(fit.glm)

#(c) Compute the confusion matrix and overall fraction of correct predictions. Explain what
#the confusion matrix is telling you about the types of mistakes made by logistic regres-
#sion.
probs <- predict(fit.glm, type = "response")
pred.glm <- rep("Down", length(probs))
pred.glm[probs > 0.5] <- "Up"
table(pred.glm, Direction)

#(d) Now _t the logistic regression model using a training data period from 1990 to 2008,
#with Lag2 as the only predictor. Compute the confusion matrix and the overall fraction
#of correct predictions for the held out data (that is, the data from 2009 and 2010).
train <- (Year < 2009)
Weekly.20092010 <- Weekly[!train, ]
Direction.20092010 <- Direction[!train]
fit.glm2 <- glm(Direction ~ Lag2, data = Weekly, family = binomial, subset = train)
summary(fit.glm2)
probs2 <- predict(fit.glm2, Weekly.20092010, type = "response")
pred.glm2 <- rep("Down", length(probs2))
pred.glm2[probs2 > 0.5] <- "Up"
table(pred.glm2, Direction.20092010)



#3
#(a) Create a binary variable, mpg01, that contains a 1 if mpg contains a value above its
#median, and a 0 if mpg contains a value below its median. You can compute the median
#using the median() function. Note you may _nd it helpful to use the data.frame()
#function to create a single data set containing both mpg01 and the other Auto variables.

library(MASS)
library(ISLR)
Auto=read.csv("~/Dawn R Library/Auto.csv", na.strings='NA')
Auto2=na.omit(Auto)
mpg.median=median(Auto2$mpg)
mpg01<-ifelse(Auto2$mpg>mpg.median,1,0)
Auto3=data.frame(mpg01,Auto2) #create a new dataframe

#(b) Explore the data graphically in order to investigate the association between mpg01 and
#the other features. Which of the other features seem most likely to be useful in predicting
#mpg01? 
pairs(Auto[,-9])
boxplot(mpg01~cylinders, data=Auto3)
plot(mpg01~weight, data=Auto3)
plot(mpg01~horsepower, data=Auto3)
plot(mpg01~acceleration, data=Auto3)

#(c) Split the data into a training set and a test set: the _rst half records are in the training
#set; the remaining are in the test set.
train=seq(1,nrow(Auto3)/2, by=1) #create indices for training data set
test=seq(nrow(Auto3)/2+1, nrow(Auto3))

#(d) Perform logistic regression on the training data in order to predict mpg01 using the
#variables that seemed most associated with mpg01 in (b). What is the test error of the
#model obtained?
logit.auto=glm(mpg01~cylinders+weight+horsepower+acceleration, family='binomial', data=Auto3)
summary(logit.auto)

#pvalue for acceleration is not significant, reperform logistic regression wihtout it
logit.auto=glm(mpg01~cylinders+weight+horsepower, family='binomial', data=Auto3)
summary(logit.auto)
#you may also want to remove cylinders
logit.auto=glm(mpg01~weight+horsepower, family='binomial', data=Auto3)
summary(logit.auto)

# perform logistic regression with training data, use testing data for accuracy
logit.auto2=glm(mpg01~weight+horsepower, family='binomial', data=Auto3, subset=train)
logit.auto2

auto.probs=predict(logit.auto2, newdata=Auto3[test,], type="response")
auto.probs

auto.pred=rep(0,length(test))

auto.pred[auto.probs>.5]=1
table(auto.pred,mpg01[test])
table(auto.pred,Auto3$mpg01[test])
table(auto.pred,Auto3$mpg01[test])->test.table
test.table
#(66+91)/196=0.8010204
mean(auto.pred==mpg01[test])

prediction.accuracy<-(test.table[1,1]+test.table[2,2])/sum(test.table)
prediction.accuracy
