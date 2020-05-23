# Småplukk

Denne delen består av mindre, uavhengige oppgaver som tester spesifikke ferdigheter.

## String-håndtering

**[Joiner](Joiner.java)**

Denne klassen hjelper til med formattering av oppramsinger av typen, "en, to og tre". Poenget er at en har to måter å skille elementer på,
én som brukes mellom alle elementene utenom de to siste og én som brukes mellom de to siste. Separatorene (mainSeparator og lastSeparator) kan være like, som i eksempelet "en, to, tre, fire".

- Skriv metodene som mangler i **Joiner**-klassen.

## Testing

**[Summer](Summer.java)** og **[SummerTest](SummerTest.java)**

**Summer**-klassen inneholder tre metoder med kode som virker i noen tilfeller (bl.a. de som testes av eksisterende testmetoder i **SummerTest**), men feiler i andre.
Oppgaven går ut på å utvide **SummerTest**-klassen med ekstra testmetoder som avdekker disse feilene på en hensiktsmessig måte. Du skal altså ikke fikse på koden, bare lage testene.

- Skriv nødvendige metoder i **SummerTest**-klassen.

**[MedianComputer](MedianComputer.java)** og **[MedianComputerTest](MedianComputerTest.java)**

Følgende figur fra [Wikipedia](https://en.wikipedia.org/wiki/Median) beskriver beregning av median-verdien til en samling tall. 

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Finding_the_median.png/2560px-Finding_the_median.png" width="300"/>

- Deklarer en **compute**-metode i **MedianComputer**-klassen som passer for formålet å beregne median.

- Skriv en eller flere testmetoder i **MedianComputerTest**-klassen som tester at **compute**-metoden virker som den skal, og på en måte som avdekker det du anser som mulige feil.

Du trenger deklarasjonen av **compute** for å kunne skrive testene, men du trenger *ikke* implementere den, bare skrive nok kode til at den kompilerer. Om du velger å implementere den, f.eks. for å kunne kjøre testen-klassen, så vil vi ikke vurdere implementasjonen, kun deklarasjonen og test-logikken. Legg merke til behovet for avrunding i AssetEquals, eksempel på toppen av koden.
