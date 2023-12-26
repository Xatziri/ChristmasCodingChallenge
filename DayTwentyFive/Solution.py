# Enter your code here. Read input from STDIN. Print output to STDOUT
import re

def is_valid_credit_card(card_number):
    # Check if it starts with 4, 5, or 6
    if not re.match(r'^[4-6]', card_number):
        return 'Invalid'
  
    # Remove hyphens and check if it contains only digits
    card_number = card_number.replace('-', '')
    if not card_number.isdigit():
        return 'Invalid'

    # Check if it has exactly 16 digits
    if not re.match(r'^\d{16}$', card_number):
        return 'Invalid'

    # Check if it has 4 or more consecutive repeated digits
    if re.search(r'(\d)\1{3,}', card_number):
        return 'Invalid'

    return 'Valid'

# Input
N = int(input().strip())
for _ in range(N):
    card_number = input().strip()
    print(is_valid_credit_card(card_number))
