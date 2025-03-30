def getDataInput(filename):
    records = []
    with open(filename, 'r') as file:
        lines = file.readlines()
        for line in lines[1:]: # Ensuring that we skip the header of the CSV file
            records.append(line.strip()) # Reading each record as a whole
    return records

def getMedian(data_list):
    data_list.sort()
    n = len(data_list)

    if n % 2 == 1: # Odd number of elements
        return float(data_list[n // 2])
    else:  # Even number of elements
        mid1 = data_list[n // 2 - 1]
        mid2 = data_list[n // 2]
        return (float(mid1) + float(mid2)) / 2

def main(filename):
    # Getting data from file
    records = getDataInput(filename)

    # Initializing dictionaries and lists for calculations
    city_totals = {}
    zip_totals = {}
    type_totals = {}
    property_prices = []

    # Process each record
    for record in records:
        fields = record.split(',') # Splitting the field at ,

        city = fields[1].strip()
        property_type = fields[7].strip()
        price = float(fields[8].strip())

        # Add price to the list of all prices
        property_prices.append(price)

        # Summing prices by city
        if city not in city_totals:
            city_totals[city] = 0
        city_totals[city] += price

        # Summing prices by zip
        zip_code = fields[2].strip()
        if zip_code not in zip_totals:
            zip_totals[zip_code] = 0
        zip_totals[zip_code] += price

        # Summing prices by property type
        if property_type not in type_totals:
            type_totals[property_type] = 0
        type_totals[property_type] += price

    # Sorting the list of property prices
    property_prices.sort()

    # Calculate and print statistics for property prices
    min_price = property_prices[0]
    max_price = property_prices[-1]
    total_price = sum(property_prices)
    avg_price = total_price / len(property_prices)
    median_price = getMedian(property_prices)

    # Output the summaries by city
    print(f"Minimum: ${min_price:,.2f}")
    print(f"Maximum: ${max_price:,.2f}")
    print(f"Sum: ${total_price:,.2f}")
    print(f"Avg: ${avg_price:,.2f}")
    print(f"Median: ${median_price:,.2f}")

    # Output the summaries by property type
    print("\nSummary by Property Type:")
    for property_type, total in type_totals.items():
        print(f"{property_type}: ${total:,.2f}")

    # Output the summaries by city
    print("\nSummaries by City:")
    for city, total in city_totals.items():
        print(f"{city}: ${total:,.2f}")

    # Output the summaries by zip code
    print("\nSummaries by Zip Code:")
    for zip_code, total in zip_totals.items():
        print(f"{zip_code}: ${total:,.2f}")

filename = "RealEstateData.csv" # Replace with your file name
main(filename)