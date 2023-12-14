# Read the first number as N (total count)
read -r n

# Check if N is zero
if [ "$n" -eq 0 ]; then
    echo "Cannot calculate average for zero integers."
    exit 1
fi

# Check if N is within the specified range
if [ "$n" -lt 1 ] || [ "$n" -gt 500 ]; then
    echo "Error: N must be between 1 and 500."
    exit 1
fi

# Initialize sum
sum=0

# Read N integers
for ((i=0; i<n; i++)); do
    read -r num
    # Check if the entered number is within the specified range
    if [ "$num" -lt -10000 ] || [ "$num" -gt 10000 ]; then
        echo "Error: Entered number must be between -10000 and 10000."
        exit 1
    fi
    sum=$((sum + num))
done

# Calculate the average and round using awk
average=$(awk "BEGIN {printf \"%.3f\", $sum / $n}")

# Display the average
echo $average
