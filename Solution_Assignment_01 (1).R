#### Solution Code for Assignment 01
> Auto=read.csv("Auto.csv",header=T,na.strings="?")
> Auto=na.omit(Auto)
> attach(Auto)


## problem 2
Auto=read.csv("Auto.csv",header=T,na.strings="?")
dim(Auto)
Auto=na.omit(Auto)
class(Auto$horsepower)
dim(Auto)
attach(Auto)


Auto=read.csv("Auto.csv")
Auto$horsepower[Auto$horsepower=="?"]=NA
Auto=na.omit(Auto)
dim(Auto)
class(Auto$horsepower)
Auto$horsepower=as.numeric(Auto$horsepower)
class(Auto$horsepower)


class(Auto)
class(Auto$mpg)
class(Auto$horsepower)
head(Auto)
names(Auto)


Auto2=read.csv("Auto.csv")
class(Auto$horsepower)
Auto$horsepower[Auto$horsepower=="?"]=NA

range(mpg)
mean(mpg)
sd(mpg)


Auto2=Auto[-seq(10,85),]
attach(Auto2)
range(mpg)
mean(mpg)
sd(mpg)


detach(Auto2)
plot(acceleration~horsepower, data=Auto)
plot(horsepower~displacement, data=Auto)
plot(mpg~displacement, data=Auto)
plot(mpg~horsepower, data=Auto)
plot(mpg~weight, data=Auto)
plot(mpg~acceleration, data=Auto)
