#VECTORS IS A LIST OF ITEMS THAT ARE OF THE SAME TYPE
#VECTOR OF STRINGS
veg<-c("aloo","tomato","ladyfinger")
length(veg)

#NUMERICAL VECTOR
age = c(40,70,10)
age[c(-2)] #negative index removes that element

age[-1]

veg[1] <- "ALOO" #replace element at index

repeat1 <- rep(c(2,4,6),each=4) #repeat vectors

repeat2 <- rep(c(2,4,6), times = 3)
repeat2

repeat3 <- rep(c(2,4,6) , times = c(5,3,2))
repeat3

#LISTS - a collection of different types of data

#CREATE A LIST OF NUMBERS

NUMS <- list(c(1,2,3,4,5,6))
NUMS

#CHANGE VALUE
NUMS[1]
NUMS[2] = 10
NUMS
