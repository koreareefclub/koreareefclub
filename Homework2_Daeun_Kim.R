###homework 2

#Question 1
GMAT=c(560,540,520,580,520,620,660,630,550,550,600,537)
GPA=c(3.20,3.44,3.70,3.10,3.00,4.00,3.38,3.83,2.67,2.75,2.33,3.75)
lm(GPA~GMAT)-> Tuesday
predict(Tuesday, data.frame(GMAT=540))
summary(Tuesday)
?data.frame

#Question 3
library(ISLR)
data(Auto)#don't have to put Auto$ in front of everything
Auto=na.omit(Auto)
fit <- lm(mpg ~ horsepower, data = Auto)
summary(fit)

predict(fit,data.frame(horsepower=98))
predict(fit, data.frame(horsepower=98),interval="confidence", level=0.95)
predict(fit, data.frame(horsepower=98),interval="prediction", level=0.95)
plot(Auto$horsepower, Auto$mpg, main="Scatterplot", xlab="horsepower", ylab="mpg", col='blue')
abline(hponmpg, col='red')
par(mfrow=c(2,2))
plot(fit)

#question 4
set.seed(1)
x=rnorm(100,mean=0,sd=1)
e=rnorm(100,mean=0,sd=sqrt(0.25))
y=-1+0.5*x+e

#1
length(y)
#d
plot(x,y)
#e
lm(y~x)->fit9
summary(fit9)

#f
fit10 <- lm(y ~ x + I(x^2))
summary(fit10)

#g
set.seed(1)
eps <- rnorm(100, sd = 0.125)
x <- rnorm(100)
y <- -1 + 0.5 * x + eps
plot(x, y)
fit11 <- lm(y ~ x)
summary(fit11)

###original plot
#plot(x, y)
#abline(fit9, col = "red")
#abline(-1, 0.5, col = "blue")
#legend("topleft", c("Least square", "Regression"), col = c("red", "blue"), lty = c(1, 1))

abline(fit11, col = "red")
abline(-1, 0.5, col = "blue")
legend("topleft", c("Least square", "Regression"), col = c("red", "blue"), lty = c(1, 1))

#h
set.seed(1)
eps <- rnorm(100, sd = 0.5)
x <- rnorm(100)
y <- -1 + 0.5 * x + eps
plot(x, y)
fit12 <- lm(y ~ x)
summary(fit12)

abline(fit12, col = "red")
abline(-1, 0.5, col = "blue")
legend("topleft", c("Least square", "Regression"), col = c("red", "blue"), lty = c(1, 1))

#i
confint(fit9)
confint(fit11)
confint(fit12)
