#!/bin/python3

## https://www.hackerrank.com/challenges/ctci-coin-change/submissions/code/65195432

import sys

mem = [[-1 for i in range(251)] for j in range(51)];

def make_change(coins, n):
    ways=0;
    if n<0 :
        return 0
    elif n == 0:
        return 1
    elif mem[len(coins)][n] != -1:
        return mem[len(coins)][n]
    else :
        for i in range(0,len(coins)) :
            if(coins[i]<=n):
                k=make_change(coins[i:],n-coins[i])
                ways = ways + k
                
    mem[len(coins)][n]=ways
    """print(coins)
    print(mem)
    print(str(len(coins)) + " " + str(n) + " "  + str(ways))"""
    return ways

n,m = input().strip().split(' ')
n,m = [int(n),int(m)]
coins = [int(coins_temp) for coins_temp in input().strip().split(' ')]
print(make_change(coins, n))
