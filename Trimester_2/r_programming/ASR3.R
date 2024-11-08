# Counts of each unique value in random
random <- c(1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2)

# First barplot using table to show frequency counts
barplot(table(random))

# Creating a frequency table for the labels "Apple" and "Oranges"
fruit_counts <- c(Apple = sum(random == 1), Oranges = sum(random == 2))

# Second barplot with correct parameters
barplot(fruit_counts, main = "Fruits", col = c("red", "blue"), horiz = TRUE)


cost = matrix(10,20,55,60,50,10,15,66,14,29,50,36,nrow = 4,ncol = 3)

pie(random)

pie(table(random),main = "Numbers",col = c("red","blue"),labels = c("no.1","no.2"))
install.packages("plotrix")
library(plotrix)

pie3D(table(random),main = "Numbers",col = c("red","blue"),labels = c("no.1","no.2"))

?hist()
height=c(100,101,102,103,104,105,106,107,108,109,110)
hist(height,col = c("red","green","blue","orange","pink"),xlab = "Heights",ylab = "Occurences",border = blues9)

plot(density(height,adjust = 1))
?density()

quantile(height,probs = seq(0,1,0.01))

files <-



