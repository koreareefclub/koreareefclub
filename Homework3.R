x
e
y
x2=x^2
x3=x^3

datax=data.frame(x,x2,x3)

regsubsets(y~x+I(x^2)+I(x^3)+, data=data.frame(x,y))
