# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import product
def maximize_s(K, M, lists):
    max_s = 0 
    # Generate all possible combinations
    combinations = product(*lists)

    # Calculate S for each combination and find the maximum
    for combination in combinations:
        S = sum(x**2 for x in combination) % M
        max_s = max(max_s, S)

    return max_s

# Input
K, M = map(int, input().split())
lists = []
for _ in range(K):
    elements = list(map(int, input().split()[1:]))
    lists.append(elements)

# Output
result = maximize_s(K, M, lists)
print(result)