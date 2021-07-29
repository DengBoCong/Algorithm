class ParkingSystem:
    def __init__(self, big: int, medium: int, small: int):
        self.remain = [big, medium, small]

    def addCar(self, carType: int) -> bool:
        if self.remain[carType - 1] > 0:
            self.remain[carType - 1] -= 1
            return True
        else:
            return False