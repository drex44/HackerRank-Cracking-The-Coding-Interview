#!/bin/python3

## https://www.hackerrank.com/challenges/ctci-merge-sort/problem

import sys
c=0

def countInversions(arr):
    # Complete this function
    #print(arr)
    global c
    c=0
    mergeSort(arr, 0, len(arr))
    return c
    
def mergeSort(arr, p, q):
    if(p<q):
        r = int(int(p+q)/2)
        if p!=r:
            mergeSort(arr, p, r)
        if r+1!=q:
            mergeSort(arr, r+1, q)
        #print (p,r,q)
        if r!=len(arr)-1 and arr[r]>arr[r+1]:
            merge(arr, p,r,q)

def merge(arr, p, r, q):
    s1=0
    s2=0
    global c
    arrl = arr[p:r+1]
    arrl.append(sys.maxsize)
    arrr = arr[r+1:q+1]
    arrr.append(sys.maxsize)
    arr2 = []
    ma = sys.maxsize
    while arrl[s1]!=ma and arrr[s2]!=ma:
        #print(s1,s2,arrl,arrr)
        if(arrl[s1] <= arrr[s2]):
            arr2.append(arrl[s1])
            s1+=1
        else:
            c+=len(arrl)-1-s1
            arr2.append(arrr[s2])
            s2+=1

    while s1 < len(arrl)-1:
        arr2.append(arrl[s1])
        s1+=1
    while s2 < len(arrr)-1:
        arr2.append(arrr[s2])
        s2+=1

    arr[p:q+1] = arr2
#    print(arr,c)
    return arr

if __name__ == "__main__":
    t = int(input().strip())
    for a0 in range(t):
        n = int(input().strip())
        arr = list(map(int, input().strip().split(' ')))
        result = countInversions(arr)
        print(result)
