#1. (a)Use the rnorm function to generate a predictor X of length n = 100, as wells as noise vector  of length n = 100
set.seed(100)
x = rnorm(100, 2, 2)
set.seed(200)
epsilon = rnorm(100, 0, 1)

#(b)Generate a response vector Y of length n = 100 according to the model
#Y = 0 + 1X + 2X2 + 3X3 + , where 0; 1; 2; and 3 are constants of your choice.
beta = sample(1:100, 4, replace=TRUE)
y= beta[1]+beta[2]*x+beta[3]*x^2+beta[4]*x^3+epsilon

#(c)Use the regsubsets() function to perform best subset selection in order to
#choose the best model containing the predictors X;X2; : : : ;X10. What is the best model
#obtained accordng to Cp, BIC and adjusted R2? Show some plotsto provide evidence for
#your answer. Note you will need to use the data.frame() function to create a single data set
#containing both X and Y .
library(leaps)
best.full=regsubsets(y~x+I(x^2)+I(x^3)+I(x^4)+I(x^5)+I(x^6)+I(x^7)+I(x^8)+I(x^9)+I(x^10),
                     data=data.frame(x=x,y=y),nvmax=10)
best.summary=summary(best.full)
par(mfrow=c(1,3))
plot(1:10, best.summary$cp, xlab="Number of Predictors", ylab="Cp", type="l")
cp.min=min(best.summary$cp)
points(c(1:10)[best.summary$cp==cp.min], cp.min, pch=2, col="red")
plot(1:10, best.summary$bic, xlab="Number of Predictors", ylab="BIC", type="l")
bic.min=min(best.summary$bic)

points(c(1:10)[best.summary$bic==bic.min], bic.min, pch=2, col="red")
plot(1:10, best.summary$adjr2,xlab="Number of Predictors", ylab="Adjusted R Square",
     type="l")
adjr2.max=max(best.summary$adjr2)
points(c(1:10)[best.summary$adjr2==adjr2.max], adjr2.max, pch=2, col="red")

#(d) Repeat (c), using forward stepwise selection and also using backwards stepwise
#selection. How does your answer compare to the results in (c).

# Stepwise Forward Selection #
best.frd=regsubsets(y~x+I(x^2)+I(x^3)+I(x^4)+I(x^5)+I(x^6)+I(x^7)+I(x^8)+I(x^9)+I(x^10),
                    data=data.frame(x=x,y=y),nvmax=10, method="forward")
frd.summary=summary(best.frd)
par(mfrow=c(1,3))
plot(1:10, frd.summary$cp, xlab="Number of Predictors", ylab="Cp", type="l")
cp.min=min(frd.summary$cp)
points(c(1:10)[frd.summary$cp==cp.min], cp.min, pch=2, col="red")
plot(1:10, frd.summary$bic, xlab="Number of Predictors", ylab="BIC", type="l")
bic.min=min(frd.summary$bic)
points(c(1:10)[frd.summary$bic==bic.min], bic.min, pch=2, col="red")
plot(1:10, frd.summary$adjr2,xlab="Number of Predictors", ylab="Adjusted R Square", type="l")
adjr2.max=max(frd.summary$adjr2)
points(c(1:10)[frd.summary$adjr2==adjr2.max], adjr2.max, pch=2, col="red")

#Backward Selection#
best.bkd=regsubsets(y~x+I(x^2)+I(x^3)+I(x^4)+I(x^5)+I(x^6)+I(x^7)+I(x^8)+I(x^9)+I(x^10),
                    data=data.frame(x=x,y=y),nvmax=10, method="backward")
bkd.summary=summary(best.bkd)
par(mfrow=c(1,3))
plot(1:10, bkd.summary$cp, xlab="Number of Predictors", ylab="Cp", type="l")
cp.min=min(bkd.summary$cp)
points(c(1:10)[bkd.summary$cp==cp.min], cp.min, pch=2, col="red")
plot(1:10, bkd.summary$bic, xlab="Number of Predictors", ylab="BIC", type="l")
bic.min=min(bkd.summary$bic)
points(c(1:10)[bkd.summary$bic==bic.min], bic.min, pch=2, col="red")
plot(1:10, bkd.summary$adjr2,xlab="Number of Predictors", ylab="Adjusted R Square", type="l")
adjr2.max=max(bkd.summary$adjr2)
points(c(1:10)[bkd.summary$adjr2==adjr2.max], adjr2.max, pch=2, col="red")

#(a)Best subset selection with three predictor. 
#What are the best three predictors?
library(ISLR)
fix(Boston)
Boston=na.omit(Boston)
library(leaps)
regfit.full=regsubsets(medv~.,Boston)
summary(regfit.full)



#(b)Perform linear regression with the three best predictors. 
#Is your model significant? 
#How much variability can be explained by this linear model?

fit.all<- lm(medv~rm+ptratio+lstat, data=Boston)
summary(fit.all)

#(c)Perform forward and backward stepwise subset selection. 
#Find the models with seven predictors. 
#Are they the same as the best subset selection? 
#If different, does the stepwise subset selection lose much in terms of proportion of variability explained by the model?

regfit.fwd=regsubsets(medv~.,data=Boston, method="forward")
summary(regfit.fwd)

regfit.bkd=regsubsets(medv~.,data=Boston, method="backward")
summary(regfit.bkd)
