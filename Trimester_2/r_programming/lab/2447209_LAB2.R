# vectors of student names and marks
student_names <- c("Anjaney", "Dave", "Shrey")
math_marks <- c(100, 99, 97)
science_marks <- c(100, 99, 96)
english_marks <- c(100, 98, 95)

# matrix to rows represent students and columns represent subjects
student_matrix <- matrix(c(math_marks, science_marks, english_marks), nrow = 3, byrow = TRUE)

# Assigning row and column names
rownames(student_matrix) <- student_names
colnames(student_matrix) <- c("Math", "Science", "English")


print(student_matrix)

# Transpose the matrix to make subjects as rows and students as columns
transposed_matrix <- t(student_matrix)

# Printing the transposed matrix
print(transposed_matrix)




# Creating dataframes for midterm and endterm scores
midterm <- data.frame(Student = c("Anjaney", "Dave", "Shrey"),
                      Math = c(100, 99, 98),
                      Science = c(100, 99, 98),
                      English = c(100, 99, 98))

endterm <- data.frame(Student = c("Anjaney", "Dave", "Shrey"),
                      Math = c(100, 99, 98),
                      Science = c(100, 99, 98),
                      English = c(100, 99, 98))

# Mergeing the two dataframes by student names
merged_data <- merge(midterm, endterm, by = "Student", suffixes = c("_midterm", "_endterm"))

# Compute total and average marks for each student
merged_data$total_midterm <- rowSums(merged_data[, 2:4])
merged_data$total_endterm <- rowSums(merged_data[, 5:7])
merged_data$average_midterm <- rowMeans(merged_data[, 2:4])
merged_data$average_endterm <- rowMeans(merged_data[, 5:7])

# Printing merged data with totals and averages

print(merged_data)


library(reshape2)

# Melt the merged data frame into a long format
melted_data <- melt(merged_data, id.vars = "Student", 
                    measure.vars = c("Math_midterm", "Science_midterm", "English_midterm",
                                     "Math_endterm", "Science_endterm", "English_endterm"))



print(melted_data)

# Casting the data back to wide format to analyze grade distributions
wide_data <- dcast(melted_data, Student ~ variable, value.var = "value")


print(wide_data)




