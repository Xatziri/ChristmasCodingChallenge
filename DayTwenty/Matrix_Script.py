import math
import os
import random
import re
import sys




first_multiple_input = input().rstrip().split()

n = int(first_multiple_input[0])

m = int(first_multiple_input[1])

matrix = []

for _ in range(n):
    matrix_item = input()
    matrix.append(matrix_item)
    
transposed_matrix = list(map(list, zip(*matrix)))
decoded_columns = [''.join(column) for column in transposed_matrix]
decoded_script = ''.join(decoded_columns)
decoded_script = re.sub(r'(?<=[a-zA-Z0-9])[^a-zA-Z0-9]+(?=[a-zA-Z0-9])', ' ', decoded_script)
  
print(decoded_script)

