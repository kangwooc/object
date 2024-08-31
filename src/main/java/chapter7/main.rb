def main(operation, args={})
    case(operation)
    when :pay then calculatePay(args[:name])
    when "sumOfBasePays"then Employees.sumOfBasePays()
    end
end

def calculatePay(name)
    taxRate = getTaxRate()
    pay = Employees.calculatePay(name, taxRate)
    puts(describeResult(name, pay))
end

def getTaxRate()
    print("세율을 입력하세요: ")
    return gets().chomp().to_f()
end

def describeResult(name, pay)
    return "#{name}님의 이번 달 급여는 #{pay}원입니다."
end

def sumOfBasePays()
    puts("모든 직원의 기본급의 합은 #{Employees.sumOfBasePays()}원입니다.")
end
