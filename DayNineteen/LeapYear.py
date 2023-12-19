# Write a function to check if a year is a leap year or not
def is_leap(year):
    leap = False
    
    # Write your logic here
    # Leap year conditions
    if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
        return True
    else:
        return False
    return leap

year = int(input())
print(is_leap(year))