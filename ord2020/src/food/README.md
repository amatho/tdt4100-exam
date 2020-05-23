# Le Petite Chef
(Hvis du ønsker å lese denne filen med pent utseende i Eclipse, husk at du kan trykke på 'Preview'-fanen nede til venstre i md-editoren).

Le Petite Chef er en liten familierestaurant. Du har fått i oppdrag å lage et system for å holde styr på oppskrifter, et lager av matvarer (ingredienser) og innkjøp. Kokken skal bl.a. kunne bestemme hvilke oppskrifter som skal brukes neste uke (med antall), og dette skal kunne brukes ved innkjøp av matvarer.

Dette eksamenssettet bygger på at du skal utvide et eksisterende rammeverk. De fleste klassene eksisterer allerede. Dersom du har behov for å lage noen ekstra, for eksempel hjelpeklasser, så står du fritt til det. Hvis du mener at det kan det være lurt å beskrive valgene, se avsnitt om filen Oppgavekommentarer.md under.

## Sentrale klasser

Sentralt i oppgavene står håndtering av matvarer/ingredienser. F.eks. inneholder både oppskrifter og matlageret en mengde/antall av et sett med ingredienser. En ingrediens representeres med en **String** og mengden/antallet av ingrediensen med et desimaltall (**double**). 


**[Ingredients](Ingredients.java)**

Dette er et grensesnitt med metoder for å lese ut og gå gjennom et sett ingredienser og deres mengder/antall og metoder knyttet til sammenligning av sett med ingredienser. Den primære implementasjonen av **Ingredients** er **IngredientsContainer**.



**[IngredientContainer](IngredientContainer.java)**

Denne klassen er en konkret implementasjon av **Ingredients**, med ekstra metoder for å endre (legge til og fjerne) ingredienser. Denne kan brukes av andre klasser som trenger å håndtere ingredienser.

**[Recipe](Recipe.java) og [RecipeReader.java](RecipeReader.java)**

Recipe-klassen representerer en oppskrift med et sett tilhørende ingredienser for et visst antall porsjoner. Oppskrifter kan leses inn fra fil vha. **RecipeReader**-klassen.

**[Kitchen](Kitchen.java)**

Kjøkkenet har en oversikt over alle kjente oppskrifter og de oppskriftene som skal brukes i ukemenyen. I tillegg har den et lager av matvarer, som må etterfylles når en ny ukesmeny legges inn.



## Oppgavestruktur

Le Petit Chef er delt i 5 oppgaver, som er naturlige å gjøre i rekkefølge. Du bør likevel tenke på det som en helhet, og det er sluttresultatet som skal leveres inn. Klassene er allerede opprettet og inneholder (noen av de nødvendige) metodene med javadoc og **// TODO**-kommentarer som indikerer hva som må implementeres.

Her beskrives trinnene skissemessig, detaljer finnes i [oppgavebeskrivelsen](Oppgavebeskrivelse.md). Lenkene under går til toppen av oppgavebeskrivelsen, ikke til de respektive oppgavene.

[Oppgave 1](Oppgavebeskrivelse.md) handler om **IngredientContainer**, som implementerer **Ingredients**, **Recipe** og **RecipeReader**.

[Oppgave 2](Oppgavebeskrivelse.md) handler om **Kitchen**. Denne inneholder et sett med oppskrifter, et lager med ingredienser og neste ukes meny.

[Oppgave 3](Oppgavebeskrivelse.md) handler om delegering, der du skal implementere en ny metode i **Recipe**

[Oppgave 4](Oppgavebeskrivelse.md) handler om observerbarhet, der noen skal få beskjed når kokken har laget ferdig neste ukes meny.

[Oppgave 5](Oppgavebeskrivelse.md) handler om en JavaFX-app der kokken kan legge inn neste ukes meny.

## Kommentering av egen kode
Eclipse sin md-editor har faner nede til venstre for å skrive (**Markdown Source**) og én for å se resultatet (**Preview**). Dersom du trenger å klargjøre antakelser du mener du må gjøre eller ønsker å kommentere til sensor, så kan du gjøre det i md-filen [Oppgavekommentarer.md](Oppgavekommentarer.md), som vi har lenket til i avsnittet **Dine kommentarer**. Gå til seksjonen i denne oppgaven som passer til oppgavenummeret du er i.
