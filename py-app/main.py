from app.calculator import Calculator


def main():
    print("Python Command Line Application")

    calculator = Calculator()

    a = int(input("Enter first number: "))
    b = int(input("Enter second number: "))

    result = calculator.add(a, b)

    print("Result:", result)


if __name__ == "__main__":
    main()