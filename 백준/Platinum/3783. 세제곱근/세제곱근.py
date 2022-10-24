import decimal

def cube_root(input_num):
    decimal_num = decimal.Decimal(input_num + '.0000000000')
    pow_num = decimal.Decimal('1') / decimal.Decimal('3')
    
    decimal_num = decimal.Decimal(decimal_num ** pow_num)
    
    decimal_num = round(decimal_num, 500)
    
    decimal_num = decimal.Decimal(decimal_num).quantize(decimal.Decimal('.0000000001'), rounding=decimal.ROUND_DOWN)
    
    return decimal_num

if __name__ == "__main__":
    decimal.getcontext().prec = 1000
    for _ in range(int(input())):
        input_num = input().rstrip()
        print(cube_root(input_num))