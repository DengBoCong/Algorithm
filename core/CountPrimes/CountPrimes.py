def countPrimes(n: int) -> int:
    is_primes = [1] * n
    res = 0
    for i in range(2, n):
        if is_primes[i] == 1:
            res += 1
            for index in range(i ** 2, n, i):
                is_primes[index] = 0

    return res

def countPrimes1(n: int) -> int:
    primes = []
    is_primes = [1] * n
    for i in range(2, n):
        if is_primes[i] == 1:
            primes.append(i)
        j = 0
        while j < len(primes) and i * primes[j] < n:
            is_primes[i * primes[j]] = 0
            if i % primes[j] == 0:
                break
            j += 1

    return len(primes)


if __name__ == '__main__':
    print(countPrimes1(10))
