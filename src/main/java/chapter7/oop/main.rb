$employees = [
  SalariedEmployee.new("직원A", 400),
  SalariedEmployee.new("직원B", 300),
  SalariedEmployee.new("직원C", 250),
  HourlyEmployee.new("아르바이트D", 1, 120),
  HourlyEmployee.new("아르바이트E", 1, 120),
  HourlyEmployee.new("아르바이트F", 1, 120)
]

def sumOfBasePays()
  result = 0
  for employee in $employees
    result += employee.monthlyBasePay()
  end
  puts(result)
end