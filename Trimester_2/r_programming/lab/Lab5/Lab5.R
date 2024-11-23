library(ggplot2)
library(plyr)
library(tidyr)

# Read Employee Attrition Dataset
data <- read.csv("WA_Fn-UseC_-HR-Employee-Attrition.csv")

# Single-variable visualizations: Using 'Age' column
# 1. Bar plot
p1 <- ggplot(data, aes(x = Age)) +
  geom_bar(fill = "steelblue") + 
  labs(title = "Bar Plot of Age", x = "Age", y = "Count")

# 2. Pie chart
age_counts <- data.frame(table(data$Age))
colnames(age_counts) <- c("age", "freq")
age_counts$percentage <- (age_counts$freq / sum(age_counts$freq)) * 100
p2 <- ggplot(age_counts, aes(x = "", y = percentage, fill = as.factor(age))) +
  geom_bar(stat = "identity", width = 1) +
  coord_polar("y") +
  labs(title = "Pie Chart of Age", fill = "Age")

# 3. Box plot
p3 <- ggplot(data, aes(x = "", y = Age)) +
  geom_boxplot(fill = "lightgreen") +
  labs(title = "Box Plot of Age", y = "Age", x = "")

# 4. Density plot
p4 <- ggplot(data, aes(x = Age)) +
  geom_density(fill = "purple", alpha = 0.5) +
  labs(title = "Density Plot of Age", x = "Age", y = "Density")

# 5. Histogram
p5 <- ggplot(data, aes(x = Age)) +
  geom_histogram(binwidth = 5, fill = "orange", color = "black", alpha = 0.7) +
  labs(title = "Histogram of Age", x = "Age", y = "Frequency")

# Two-variable visualizations:
# 1. Bar plot (Count of Attrition per Department)
p6 <- ggplot(data, aes(x = Department, fill = Attrition)) +
  geom_bar(position = "dodge") +
  labs(title = "Bar Plot of Department by Attrition", x = "Department", y = "Count") +
  scale_fill_manual(values = c("steelblue", "lightgreen"))

# 2. Scatter plot (Age vs. Monthly Income)
p7 <- ggplot(data, aes(x = Age, y = MonthlyIncome, color = Attrition)) +
  geom_point(alpha = 0.6) +
  labs(title = "Scatter Plot of Age vs Monthly Income", x = "Age", y = "Monthly Income") +
  scale_color_manual(values = c("steelblue", "lightgreen"))

# 3. Violin plot (Age distribution by Job Level)
p8 <- ggplot(data, aes(x = factor(JobLevel), y = Age, fill = factor(JobLevel))) +
  geom_violin(trim = TRUE) +
  labs(title = "Violin Plot of Age Distribution by Job Level", x = "Job Level", y = "Age") +
  scale_fill_brewer(palette = "Set3")

# 4. Box plot (Monthly Income by Department)
p9 <- ggplot(data, aes(x = Department, y = MonthlyIncome, fill = Department)) +
  geom_boxplot() +
  labs(title = "Box Plot of Monthly Income by Department", x = "Department", y = "Monthly Income") +
  scale_fill_brewer(palette = "Set2")

# Multi-variable visualizations:
# Selecting numerical columns
numerical_data <- data[c("Age", "MonthlyIncome", "TotalWorkingYears", "YearsAtCompany")]

# Reshape data to long format
long_data <- ldply(names(numerical_data), function(var) {
  data.frame(Age = numerical_data$Age, 
             value = numerical_data[[var]], 
             variable = var)
})

# 1. Bar Plot (Job and Attrition)
p10 <- ggplot(data, aes(x = JobRole, fill = Attrition)) + 
  geom_bar(position = "dodge") + 
  labs(title = "Bar Plot of Job Role by Attrition", x = "Job Role", y = "Count") +
  scale_fill_manual(values = c("steelblue", "lightgreen")) +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))

# 2. Pair Plot (Numerical Variables)
p11 <- ggplot(long_data, aes(x = Age, y = value, color = variable)) +
  geom_point(alpha = 0.6) +
  facet_wrap(~variable, scales = "free") +
  labs(title = "Pair Plot of Numerical Variables", x = "Age", y = "Value") +
  scale_color_brewer(palette = "Set1")

# Arrange and display plots
library(gridExtra)
grid.arrange(p1, p2, p3, p4, p5, ncol = 3)
grid.arrange(p6, p7, p8, p9, ncol = 2)
grid.arrange(p10, p11, ncol = 2)

# Metadata and Summary
print(summary(data))