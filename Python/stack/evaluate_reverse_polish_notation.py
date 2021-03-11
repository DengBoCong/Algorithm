from typing import List

def evalRPN(tokens: List[str]) -> int:
    stack = list()
    for token in tokens:
        if token not in "+-*/":
            stack.append(int(token))
        else:
            a = stack.pop()
            b = stack.pop()
            if token == '+':
                stack.append(a + b)
            elif token == '-':
                stack.append(b - a)
            elif token == '*':
                stack.append(a * b)
            else:
                stack.append(int(b / a))
    
    return stack[-1]

if __name__ == "__main__":
    print(evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))