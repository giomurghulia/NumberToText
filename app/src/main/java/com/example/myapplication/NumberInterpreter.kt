package com.example.myapplication

class NumberInterpreter(
    private val number: Int
) {
    private val mainNumberKey = arrayOf(
        "ნული",
        "ერთ",
        "ორ",
        "სამ",
        "ოთხ",
        "ხუთ",
        "ექვს",
        "შვიდ",
        "რვა",
        "ცრხა",
        "ათ",
        "თერთმეტი",
        "თორმეტი",
        "ცამეტი",
        "თოთხმეტი",
        "თხუთმეტი",
        "თექვსმეტი",
        "ჩვიდმეტი",
        "თვრამეტი",
        "ცხრამეტი"
    )

    private val twentyKey = arrayOf("", "ოც", "ორმოც", "სამოც", "ოთხმოც")

    private val numberThousandPart = number / 1000
    private val numberHundredPart = number % 1000 / 100
    private val numberTenPart = number % 1000 % 100
    private val numberTwentyPart = numberTenPart / 20
    private val numberUnityPart = numberTenPart % 20

    fun readNumber(): String {
        if (number == 0) return mainNumberKey[number]
        if (number == 1000000) return "მილიონი"

        val numText = buildString {
            append(readThousandPart().orEmpty())
            append(readHundredPart().orEmpty())
            append(readTenPart().orEmpty())
            append(readUnitPart().orEmpty())
            append(if (numberUnityPart <= 7 || numberUnityPart == 10) "ი" else "")
        }
        return numText
    }

    private fun readThousandPart(): String? {
        if (numberThousandPart == 0) return null
        return if (numberThousandPart != 1) NumberInterpreter(numberThousandPart).readNumber() + "ათას" else "ათას"
    }

    private fun readHundredPart(): String? {
        if (numberHundredPart == 0) return null
        return if (numberHundredPart != 1) mainNumberKey[numberHundredPart] + "ას" else "ას"
    }

    private fun readTenPart(): String? {
        if (numberTenPart == 0) return null
        return if (numberTwentyPart != 0 && numberUnityPart != 0) {
            twentyKey[numberTwentyPart] + "და"
        } else twentyKey[numberTwentyPart]
    }

    private fun readUnitPart(): String? {
        if (numberUnityPart == 0) return null
        return mainNumberKey[numberUnityPart]
    }
}