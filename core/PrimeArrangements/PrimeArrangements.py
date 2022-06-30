def numPrimeArrangements(n: int) -> int:
    def count_prime(num: int):
        is_prime = [True] * num
        primes = []
        for i in range(2, num + 1):
            if is_prime[i - 1]:
                primes.append(i)
            for prime in primes:
                if i * prime > num:
                    break
                is_prime[i * prime - 1] = False
                if i % prime == 0:
                    break
        return len(primes)

    prime_count = count_prime(n)
    res = 1
    for item in range(1, prime_count + 1):
        res *= item
    for item in range(1, n - prime_count + 1):
        res *= item

    return res % (10**9 + 7)






