Employee = Struct.new(:name, :basePay, :hourly, :timeCard) do
  def calculatePay(taxRate)
    if hourly then
      return calculateHourlyPay(taxRate)
    else
      return calculatePay(taxRate)
    end
  end

  def monthlyBasePay()
    if (hourly) then return 0 end
    return basePay
    end
private 
  def calculateHourlyPay(taxRate)
    return (basePay * timeCard) - (basePay * timeCard) * taxRate
  end

  def calculatePay(taxRate)
    return basePay - (basePay * taxRate)
  end
end