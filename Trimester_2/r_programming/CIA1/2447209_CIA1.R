#reading the csv file with the dataset
data1 = read.csv("~/MCA/Trimester_2/r_programming/CIA1/SalaryDataset.csv")

#printing the dataset
data1
#?data.frame
rank = (data1$Rank)
rank

years_in_rank = (data1$Years.Rank)
years_in_rank

salary = data.frame(data1$Salary)


gender = (data1$Gender)
gender

degree = (data1$HighDegree)
degree

years_since_degree = (data1$Years.Degree)
years_since_degree

#Q1
#10 COMMANDS

max(salary) #maximum value in the dataset is displayed

min(salary) #minimum value in the dataset is displayed

which.max(years_in_rank) #location (in terms of index) of maximum value

which.min(years_in_rank) #location (in terms of index) of minimum value

typeof(gender) #displays the type of data 

length(gender) #length of the specific data set is displayed, in this case, the gender column

sort(data1$Salary) #sort in ascending order

sort(data1$Salary,decreasing = TRUE) #sort in descending order

sum(salary) #total of the salary column


type.convert(gender,character(length = 10),as.is=TRUE) #convert the type of data
typeof(gender)


#Q2
#Calculating mean, median, variance and standard deviation
3?var
#?sd

doctorate = (data1$HighDegree == 1) #check if degree is doctorate
doctorate

doctorate_salary = cbind(doctorate,salary) #combine doctorate with salary
doctorate_salary



mean(doctorate_salary)
masters_salary = (data1$HighDegree<1)
masters_salary

mean(data1$Salary)
median(data1$Salary)
var(data1$Salary)
sd(data1$Salary)

professors_20 = (data1$Years.Degree>20 && data1$HighDegree > 0)
professors_20


#Q3
#PLOTTING
?boxplot

gender_salary = cbind(gender,salary)
gender_salary

plot(data1$Salary,data1$Gender)


boxplot(gender_salary,xlab="Gender",ylab="Salary",range = 0)

hist(data1$Salary)
pie(data1$Salary)
#?pie

#Insights
#The boxplot shows the outliers as well as the salary based on gender



