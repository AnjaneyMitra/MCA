#1. Define and explain why statistics is important for data analytics
#1. Answer - Statistics is the science of collecting, analyzing, and interpreting data to uncover patterns, trends, and insights. In data analytics, it helps ensure data accuracy, supports decision-making by providing evidence-based insights, enables hypothesis testing, and assists in predictive analysis for future outcomes.

#A school library wants to keep track of how many books are borrowed from each genre every week. The library has the following genres: Fiction, Non-Fiction, Science, History, and Technology.

genres <- c("Fiction", "Non-Fiction", "Science", "History", "Technology")
weeks <- 1:52


#A group of 50 students is surveyed to determine their favorite fruit from the following choices: Apples, Bananas, Oranges, and Grapes.  
favorite_fruits <- c("Apples", "Bananas", "Oranges", "Grapes")
students <- 50


#The local weather station records the amount of rainfall (in millimeters) each day for a week.
rainfall <- c(10, 5, 8, 12, 6, 9, 7)

#A company wants to evaluate the performance of its employees based on three factors: the number of tasks completed per week, the number of hours worked, and the employee's satisfaction rating (on a scale of 1 to 10).
performance_data <- data.frame(
  tasks_completed = c(5, 7, 4, 6, 8),
  hours_worked = c(40, 35, 42, 38, 45),
  satisfaction_rating = c(8, 9, 7, 6, 9)
)

# Calculate Spread (Range, Variance, Standard Deviation) for cafe dataset
range_cafe <- diff(range(cafe_data$Items_Sold))    # Range
variance_cafe <- var(cafe_data$Items_Sold)         # Variance
sd_cafe <- sd(cafe_data$Items_Sold)                # Standard Deviation

# Calculate Skewness and Kurtosis
skewness_cafe <- skewness(cafe_data$Items_Sold)
kurtosis_cafe <- kurtosis(cafe_data$Items_Sold)

# Display the results
cat("Range of items sold:", range_cafe, "\n")
cat("Variance of items sold:", variance_cafe, "\n")
cat("Standard Deviation of items sold:", sd_cafe, "\n")
cat("Skewness of items sold:", skewness_cafe, "\n")
cat("Kurtosis of items sold:", kurtosis_cafe, "\n")
