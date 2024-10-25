# Task 1: Create vectors for employee names, departments, and performance scores
employee_names <- c("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack", "Kelly", "Liam")
departments <- c("HR", "HR", "HR", "HR", "IT", "IT", "IT", "IT", "Sales", "Sales", "Sales", "Sales")
Q1_scores <- c(85, 88, 90, 75, 95, 92, 85, 87, 80, 85, 88, 82)
Q2_scores <- c(82, 89, 91, 80, 93, 88, 84, 85, 78, 86, 87, 83)
Q3_scores <- c(84, 87, 92, 78, 94, 89, 86, 88, 81, 87, 90, 84)

# Task 2: Combine performance scores into a matrix
performance_matrix <- cbind(Q1_scores, Q2_scores, Q3_scores)
rownames(performance_matrix) <- employee_names
performance_matrix

# Task 3: Convert the matrix into a data frame with department and employee names
employee_data <- data.frame(Employee = employee_names, 
                            Department = departments, 
                            Q1 = Q1_scores, 
                            Q2 = Q2_scores, 
                            Q3 = Q3_scores)
employee_data

# Task 4: Modify employee performance scores in the matrix and data frame
# increase Bob's Q1 score by 5 points
performance_matrix["Bob", "Q1_scores"] <- performance_matrix["Bob", "Q1_scores"] + 5
employee_data[employee_data$Employee == "Bob", "Q1"] <- employee_data[employee_data$Employee == "Bob", "Q1"] + 5

performance_matrix
employee_data

# Task 5: Calculate the average performance score per employee and per department
# Average performance score per employee
employee_data$Average <- rowMeans(employee_data[, 3:5])
employee_data

# Average performance score per department
average_per_department <- aggregate(employee_data$Average, by = list(employee_data$Department), FUN = mean)
colnames(average_per_department) <- c("Department", "Average_Score")
average_per_department

# Task 6: Add a new employee's performance data to the data frame
new_employee <- data.frame(Employee = "Mona", 
                           Department = "Sales", 
                           Q1 = 83, 
                           Q2 = 85, 
                           Q3 = 87,
                           Average = mean(c(83, 85, 87)))  # Calculate average score for the new employee

# Combine the new employee data with the existing employee data
employee_data <- rbind(employee_data, new_employee)
employee_data

# Task 7: Organize vectors, matrix, data frame, and calculations into a list
employee_performance_list <- list(Names = employee_names, 
                                  Departments = departments, 
                                  Performance_Matrix = performance_matrix, 
                                  Employee_Data_Frame = employee_data, 
                                  Avg_Per_Department = average_per_department)

employee_performance_list

# Task 8: Delete the performance data for one employee from the matrix and the data frame
# Let's remove "David"
performance_matrix <- performance_matrix[!rownames(performance_matrix) %in% "David", ]
employee_data <- employee_data[employee_data$Employee != "David", ]

performance_matrix
employee_data
