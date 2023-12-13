# Read the mathematical expression
read expression

# Use bc to evaluate the expression
result=$(echo "$expression" | bc -l)

# Format the result to display rounded value with three decimal places
decimal_result=$(printf "%.3f" $result)

# Print the formatted result
echo $decimal_result
