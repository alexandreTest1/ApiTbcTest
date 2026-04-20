src/
├── main/java/ge/tbc/
│   ├── data/
│   │   └── Constants.java          # URL-ები და endpoint-ები
│   ├── models/
│   │   ├── RemittanceSegment.java  # Remittance API მოდელი
│   │   └── TreasurySegment.java    # Treasury API მოდელი
│   ├── pages/
│   │   ├── RemittancePage.java     # Playwright locator-ები (Remittance)
│   │   └── TreasuryPage.java       # Playwright locator-ები (Treasury)
│   ├── steps/
│   │   ├── api/
│   │   │   ├── MoneyTransferApiSteps.java   # Remittance API ლოგიკა
│   │   │   └── ForwardRatesApiSteps.java    # Treasury API ლოგიკა
│   │   └── ui/
│   │       ├── RemittancePageSteps.java     # Remittance UI ლოგიკა
│   │       └── TreasuryPageSteps.java       # Treasury UI ლოგიკა
│   └── utils/
│       └── BaseTest.java           # Playwright კონფიგურაცია
└── test/java/ge/tbc/
    └── Tests.java                  # ტესტ კლასი
