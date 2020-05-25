# Småplukk

Denne delen består av mindre, uavhengige oppgåver som testar spesifikke evner.

## String-handtering

**[Joiner](Joiner.java)**

Denne klassen hjelpar til med formattering av opplistingar av typen "ein, to og tre". Poenget er at ein har to måtar (separatorar) å skilja element på,
ein som nyttast mellom alle elementa utanom dei to siste og ein som nyttast mellom dei to siste. Separatorane (mainSeparator og lasteseparator) kan vera like, som i dømet "ein, to, tre, fira".

- Skriv metodane som manglar i **Joiner**-klassen.

## Testing

**[Summer](Summer.java)** og **[SummerTest](SummerTest.java)**

**Summer**-klassen inneheld tre metodar med kode som verker i noen tilfelle (m.a. dei som vert testa av eksisterande testmetodar i **SummerTest**), men feilar i andre.
Oppgåven går ut på å utvide **SummerTest**-klassen med ekstra testmetodar som avdekker desse feila på ein formålstenleg måte. Du skal ikkje fiksa på koden, berre skriva testane.

- Skriv naudsynte metodar i **SummerTest**-klassen.

**[MedianComputer](MedianComputer.java)** og **[MedianComputerTest](MedianComputerTest.java)**

Fylgjande figur frå [Wikipedia](https://en.wikipedia.org/wiki/Median) beskriv utrekning av median-verdien til ein samling tal. 

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Finding_the_median.png/2560px-Finding_the_median.png" width="300"/>

- Deklarer ein **compute**-metode i **MedianComputer**-klassen som passar for formålet å rekne ut median.

- Skriv ein eller fleire testmetodar i **MedianComputerTest**-klassen som testar at **compute**-metoden verkar som den skal, og på ein måte som avdekker det du ser på som moglege feil.

Du treng deklarasjonen av **compute** for å kunne skriva testane, men du treng *ikkje* implementere den, berre skrive nok kode til at den kompilerer. Om du vel å implementere den, t.d. for å kunne køyra testen-klassen, så vil vi ikkje vurdere implementasjonen, kun deklarasjonen og test-logikken. Legg merke til behovet for avrunding i AssetEquals, døme på toppen av koden.
