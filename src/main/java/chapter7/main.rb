$employees = ["직원A", "직원B", "직원C"]
$basePays = [400, 300, 250]

def main(name)
    taxRate = getTaxRate()
    pay = calculatePayFor(name, taxRate)
    puts(describeResult(name, pay))
end

def getTaxRate()
    print("세율을 입력하세요: ")
    return gets().chomp().to_f()
end

def calculatePayFor(name, taxRate)
    index = $employees.index(name)
    basepay = $basePays[index]
    return basepay * (basepay - taxRate)
end

def describeResult(name, pay)
    return "#{name}님의 급여는 #{pay}입니다."
end
