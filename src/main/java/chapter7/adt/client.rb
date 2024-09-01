$employees =[
  Employee.new("직원A", 400, false, 0),
  Employee.new("직원B", 300, false, 0),
  Employee.new("직원C", 250, false, 0),
  Employee.new("직원D", 1, true, 120),
  Employee.new("직원E", 1, true, 120),
  Employee.new("직원F", 1, true, 120)
]

def calculatePay(name, taxRate)
  taxRate = getTaxRate()
  for each in $employees
    if each.name == name
      employee = each
    end
  end
  pay = employee.calculatePay(taxRate)
  puts(describeResult(name, pay))
end

def sumOfBasePays()
  result = 0
  for each in $employees
    result += each.monthlyBasePay()
  end
  puts(result)
end