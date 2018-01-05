#1
#(a)
data.hw <- read.csv("~/Dawn R Library/data-hw.csv", header=FALSE)
set.seed(2)
#x=matrix(rnorm(20*3*50), ncol=50)
#x[1:20, 2]<-1
#x[21:40, 1]<-2
#x[21:40, 2]<-2
#x[41:60, 1]<-1
#true.labels<-c(rep(1,20), rep(2, 20), rep(3,20))
x <- data.hw[,-51]
km.out<-kmeans(x,3,nstart=20)
#table(true.labels, km.out$cluster)
--------------------------------


data.clust.2=data.clust[,-51]
set.seed(100)
km.out.3=kmeans(data.clust.2,centers=3,nstart=20)
names(km.out.3)
km.out.3$cluster





#(b)
km.out<-kmeans(x,2,nstart=20)
table(true.labels, km.out$cluster)

#(c)
km.out<-kmeans(x,4,nstart=20)
table(true.labels, km.out$cluster)

#(d)
km.out <- kmeans(scale(x), 3, nstart = 20)
table(true.labels, km.out$cluster)


#2
#(a)
set.seed(2)
hc.complete<-hclust(dist(USArrests), method="complete")
par(mfrow=c(1,3))
plot(hc.complete, main="Complete Linkage", xlab="", sub="")

#(b)
cutree(hc.complete, 3)

#(c)
xsc=scale(USArrests)
plot(hclust(dist(xsc), method="complete"), main="Hierarchical Clustering with Scaled Features")
