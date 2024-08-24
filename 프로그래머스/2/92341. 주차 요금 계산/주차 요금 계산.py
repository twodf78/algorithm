from math import ceil
def timeConverter(time):
    h, m = list(map(int, time.split(":")))
    return h * 60 + m 

def solution(fees, records):
    answer = []
    
    parkingDict = {}
    basicTime, basicFee, unitTime, unitFee = fees
    
    def feeCalculator(interval):
        if interval<= basicTime:
            return basicFee
        return basicFee + ceil((interval - basicTime)/ unitTime) * unitFee
    for record in records:
        time, car, cmd = record.split()
        time = timeConverter(time)
        car = int(car)
        if(cmd == "IN"):
            if car in parkingDict:
                parkingDict[car] = {"in": time, "total": parkingDict[car]["total"]}
            else:
                parkingDict[car] = {"in": time, "total": 0}
        else:
            previous = parkingDict[car]
            parkingDict[car] = {"in": timeConverter("23:59"), "total": previous["total"] + time- previous["in"]}

    parkingList= list(parkingDict.items())
    parkingList.sort(key = lambda x:x[0])
    return list(map(lambda x: feeCalculator(x[1]["total"]) if x[1]["in"] == timeConverter("23:59") else feeCalculator(timeConverter("23:59") - x[1]["in"] +  x[1]["total"]) , parkingList))