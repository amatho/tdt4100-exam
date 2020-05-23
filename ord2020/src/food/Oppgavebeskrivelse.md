# Le Petite Chef

De fem oppgavene i denne delen følger under.

## Oppgave 1 (25%)

Denne delen handler om **IngredientContainer**, **Recipe** og **RecipeReader**.

**IngredientContainer** holder oversikt over antall/mengde av et sett med ingredienser og er den primære implementasjonen av **Ingredients**. Siden **Ingredients** bare inneholder metoder for å lese ut informasjon, må **IngredientContainer** naturlig nok legge til metoder for å endre antallet/mengden som finnes av hver ingrediens.

**Recipe** (oppskrift) representerer ingrediensene som trengs for en viss mengde porsjoner av en matrett (eller drikk). Hjelpeklassen **RecipeReader** håndterer innlesing av oppskrifter fra en kilde, f.eks. en fil.

**Oppgaven**

Implementer nødvendige metoder (og felt og hjelpeklasser og -metoder) i

- [IngredientContainer](IngredientContainer.java)
- [Recipe](Recipe.java)
- [RecipeReader](RecipeReader.java)

Dersom du ikke klarer å lese oppskrifter fra fil, så kan du senere benytte deg av den statiske metoden **Recipe.createSampleRecipes()**. Denne vil returnere en samling av oppskrifter som du kan bruke. Du finner et eksempel på dette i [KitchenController.java](KitchenController.java) som brukes i oppgave 5.

** Dine kommentarer **

Skriv kommentarer til din løsning i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgave 2 (15%)

Denne delen handler om **Kitchen** (uten observatør, de kommer i oppgave 4).

Kjøkkenet har et sett med oppskrifter (**Recipe**, som angis i konstruktøren). Noen metoder (**getRecipe** og **filterRecipes**) håndterer spørring om disse.

Kjøkkenet har et matlager (**getStorage**), som må være fylt med nok matvarer til å kunne lage rettene. Derfor har klassen metoder fokusert på sammenheng mellom oppskrifter og matlageret (**canCreateRecipe**, **getRecipesThatCanBeCreated**, **getRecipiesContainingIngredient**). 

Etter at restauranten er stengt for uken planlegger kokken neste ukes meny (vha. metodene **addRecipeToWeekly**, **removeRecipeFromWeekly** og **clearWeekly**). Denne består av et sett med eksisterende oppskrifter og et visst antall porsjoner av dem. Når alle oppskriftene er lagt inn kalles **registerWeekly**, der man f.eks. kunne tenke seg at en handleliste skal lages. Du trenger ikke å implementere funksjonalitet for en slik handleliste eller annen bruk av ukesmenyen.

**Oppgaven**

Implementer nødvendige metoder (og felt og hjelpeklasser og -metoder) i

- [Kitchen](Kitchen.java)

**Dine kommentarer**

Skriv kommentarer til din løsning i [Oppgavekommentarer](Oppgavekommentarer.md).


## Oppgave 3 - Delegering (10%)

En *skalert* oppskrift, som den som returneres av **Recipe** sin **createNPortions**-metode, kan ha nytte av en egen implementasjon av **Ingredients** implementert vha. delegering. 

**Oppgaven**

Implementer en skalert oppskrift vha. delegering og bruk denne. Du skal *ikke* endre metoden **createNPortions** som du lagde i oppgave 1, i stedet skal du lage en ekstra metode **createNPortionsUsingDelegation**. Merk: Du skal *ikke bruke* **IngredientContainer.scaleIngredients()**, klassen som får ansvaret delegert skal også implementere skaleringen.

- [ScaledIngredients](ScaledIngredients.java)
- [Recipe](Recipe.java)

**Dine kommentarer**

Skriv kommentarer til din løsning i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgave 4 - Observerbarhet (15%)

Restauranten er stengt på søndager. Da setter kokken seg ned og lager neste ukes meny. 
- Menyen for den inneværende uken slettes. 
- Kokken velger ut hvilke retter som skal serveres, og hvor mange porsjoner av hver det skal kjøpes inn til.
- Når denne jobben er ferdig skal det være mulig for eksterne enheter å få beskjed om dette. Eksempler på slike enheter kan være en innkjøpsansvarlig, eller en illustratør for ukesmenyen.
- Du skal ikke implementere noen av de eksterne lytterne, men lage kode som støtter et slikt mønster. 

**Oppgaven**

Deklarer nødvendige grensesnitt og/eller klasser som støtter observerbarhet og implementer nødvendige metoder (og felt og hjelpeklasser og -metoder) for oppførselen beskrevet overfor. Bruk det eksisterende grensesnittet [KitchenObserver](KitchenObserver.java). 

- [Kitchen](Kitchen.java)
- Du skal *ikke* implementere en lytter her, men koden din skal støtte en slik.

**Dine kommentarer**

Skriv kommentarer til din løsning i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgave 5 - JavaFX og FXML (10%)

Det er laget en app som skal hjelpe kokken med å planlegge neste ukes meny. Filen [Kitchen.fxml](Kitchen.fxml) er knyttet til Controllerklassen [KitchenController.java](KitchenController.java). Grensesnittet inneholder:

- En nedtrekksmeny der alle oppskrifter som finnes er lagt inn. Du behøver ikke å vite mye om hvordan denne nedtrekksmenyen fungerer, i oppgaven blir du kun bedt om å lese hvilken oppskrift som er valgt når en knapp trykkes inn.
- Et tekstfelt der kokken kan legge inn hvor mange porsjoner av retten som skal kunne lages neste uke.
- En knapp som, når den er trykket inn, legger inn oppskrift og antall porsjoner i neste ukes meny.
- Et tekstfelt der alle rettene som til nå er valgt er vist, sammen med antallet porsjoner av retten. Det skal oppdateres med metodekallet **updateChosen()**
- En knapp som, når den trykkes inn, bekrefter til systemet at neste ukes meny er ferdig. 

Du kan starte appen ved å kjøre [KitchenApp](KitchenApp.java).

**Oppgaven**
- Forhold deg til den eksisterende koden [Kitchen.fxml](Kitchen.fxml) og [KitchenController.java](KitchenController.java)
- Ferdigstill kontrolleren slik at den følger kravene slik de er beskrevet overfor.


**Dine kommentarer**

Skriv kommentarer til din løsning i [Oppgavekommentarer](Oppgavekommentarer.md).
