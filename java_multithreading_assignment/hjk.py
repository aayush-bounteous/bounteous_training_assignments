import csv

data = [
    ["stock_security", "stock_price"],
    ["AAPL", 175.65],
    ["GOOGL", 2835.50],
    ["MSFT", 299.01],
    ["AMZN", 3472.50],
    ["TSLA", 725.15],
    ["NFLX", 512.40],
    ["FB", 355.10],
    ["NVDA", 225.80],
    ["INTC", 53.25],
    ["IBM", 140.75],
]

with open("stocks.csv", mode="w", newline="") as file:
    writer = csv.writer(file)
    writer.writerows(data)

print("stocks.csv file created successfully.")
