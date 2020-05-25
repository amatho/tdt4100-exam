# Le Petite Chef

Dei fem oppgåvene i denne delen følgjer under.

## Oppgåve 1 (25%)

Denne delen handlar om **IngredientContainer**, **Recipe** og **RecipeReader**.

**IngredientContainer** held oversikt over talet/mengda av eit sett med ingrediensar og er den primære implementasjonen av **Ingredients**. Sidan **Ingredients** berre inneheld metodar for å lesa ut informasjon, må **IngredientContainer** naturleg nok legga til metodar for å endra talet/mengda som finst av kvar ingrediens.

**Recipe** (oppskrift) representerer ingrediensane som trengst for ei viss mengde porsjonar av ein matrett (eller drikk). Hjelpeklassen **RecipeReader** handterer innlesing av oppskrifter frå ei kjelde, t.d. ei fil.

**Oppgåva**

Implementer nødvendige metodar (og felt og hjelpeklassar og -metodar) i

- [IngredientContainer](IngredientContainer.java)
- [Recipe](Recipe.java)
- [RecipeReader](RecipeReader.java)

Dersom du ikkje klarer å lesa oppskrifter frå fil, så kan du seinare nytta deg av den statiske metoden **Recipe.createSampleRecipes()**. Denne vil returnera ei samling av oppskrifter som du kan bruka. Du finn eit døme på dette i [KitchenController.java](KitchenController.java) som blir brukt i oppgåve 5.

** Kommentarane dine**

Skriv kommentarar til løysinga di i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgåve 2 (15%)

Denne delen handlar om **Kitchen** (utan observatør, dei kjem i oppgåve 4).

Kjøkkenet har eit sett med oppskrifter (**Recipe**, som blir angitt i konstruktøren). Nokre metodar (**getRecipe** og **filterRecipes**) handterer spørjing om desse.

Kjøkkenet har eit matlager (**getStorage**), som må vera fylt med nok matvarer til å kunna laga rettane. Derfor har klassen metodar fokusert på samanheng mellom oppskrifter og matlageret (**canCreateRecipe**, **getRecipesThatCanBeCreated**, **getRecipiesContainingIngredient**). 

Etter at restauranten er stengd for veka planlegg kokken neste vekes meny (vha. metodane **addRecipeToWeekly**, **removeRecipeFromWeekly** og **clearWeekly**). Denne består av eit sett med eksisterande oppskrifter og ei viss mengde porsjonar av dei. Når alle oppskriftene er lagt inn kallas **registerWeekly**, der ein t.d. kunne tenkje seg at ein handleliste skal lagast. Du treng ikkje å implementera funksjonalitet for ein slik handleliste eller anna bruk av ukesmenyen.

**Oppgåva**

Implementer nødvendige metodar (og felt og hjelpeklassar og -metodar) i

- [Kitchen](Kitchen.java)

**Kommentarane dine**

Skriv kommentarar til løysinga di i [Oppgavekommentarer](Oppgavekommentarer.md).


## Oppgåve 3 - Delegering (10%)

Ei *skalert* oppskrift, som den som blir returnert av **Recipe** sin **createNPortions**-metode, kan ha nytte av ein eigen implementasjon av **Ingredients** implementert vha. delegering.

**Oppgåva**

Implementer ei skalert oppskrift vha. delegering og bruk denne. Du skal *ikkje* endra metoden **createNPortions** som du laga i oppgåve 1, i staden skal du laga ein ekstra metode **createNPortionsUsingDelegation**. Merk: Du skal *ikkje nytte* **IngredientContainer.scaleIngredients()** her, klassen som får ansvaret skal òg implementera skaleringen.

- [ScaledIngredients](ScaledIngredients.java)
- [Recipe](Recipe.java)

**Kommentarane dine**

Skriv kommentarar til løysinga di i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgåve 4 - Observerbarhet (15%)

Restauranten er stengd søndagar. Då set kokken seg ned og lagar neste vekes meny. 
- Menyen for den inneverande veka blir sletta. 
- Kokken vel ut kva rettar som skal serverast, og kor mange porsjonar av kvar det skal kjøpast inn til. 
- Når denne jobben er ferdig skal det vere muleg for eksterne objektar å få beskjed om dette. Døme på slike objektar kan vere ein innkjøpsansvarleg, eller ein illustratør for ukesmenyen.
- Du skal ikkje implementera nokre av dei eksterne lyttarane, men lage kode som støttar eit slikt mønster. 

**Oppgåva**

Deklarer nødvendige grensesnitt og/eller klassar som støttar observerbarhet og implementer nødvendige metodar (og felt og hjelpeklassar og -metodar) for åtferda beskrive overfor. Nytt det eksisterande grensesnittet [KitchenObserver](KitchenObserver.java).

- [Kitchen](Kitchen.java)
- Du skal *ikkje* implementera ein lyttar her, men koden din skal støtte ein slik.

**Kommentarane dine**

Skriv kommentarar til løysinga di i [Oppgavekommentarer](Oppgavekommentarer.md).

## Oppgåve 5 - JavaFX og FXML (10%)

Det er laga ein app som skal hjelpa kokken med å planlegga neste vekes meny. Fila [Kitchen.fxml](Kitchen.fxml) er knytt til Controllerklassen [KitchenController.java](KitchenController.java). Grensesnittet inneheld:

- Ein nedtrekkmeny der alle oppskrifter som finst er lagt inn. Du treng ikkje å vita mykje om korleis denne nedtrekkmenyen fungerer, i oppgåva blir du berre bedt om å lesa kva oppskrift som er vald når ein knapp blir trykt inn.
- Eit tekstfelt der kokken kan legga inn kor mange porsjonar av retten som skal kunna lagast neste veke.
- Ein knapp som, når han er trykt inn, legg inn oppskrift og talet på porsjonar i neste vekes meny.
- Eit tekstfelt der alle rettane som til no er valde er viste, saman med talet på porsjonar av retten. Det skal oppdaterast med metodekallet **updateChosen()**.
- Ein knapp som, når han blir trykt inn, stadfestar til systemet at neste vekes meny er ferdig. 

Du kan starta appen ved å kjøyra [KitchenApp](KitchenApp.java).

**Oppgåva**
- Forhald deg til den eksisterande koden [Kitchen.fxml](Kitchen.fxml) og [KitchenController.java](KitchenController.java)
- Ferdigstill kontrolleren slik at han følgjer krava slik dei er beskrivne overfor.

**Kommentarane dine**

Skriv kommentarar til løysinga di i [Oppgavekommentarer](Oppgavekommentarer.md).