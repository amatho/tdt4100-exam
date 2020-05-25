# Le Petite Chef
(Viss du ønsker å lesa denne fila med fin utsjånad i Eclipse, husk at du kan trykka på 'Preview'-fana nede til venstre i md-editoren).

Le Petite Chef er ein liten familierestaurant. Du har fått i oppdrag å laga eit system for å halda styr på oppskrifter, eit lager av matvarer (ingrediensar) og innkjøp. Kokken skal m.a. kunna bestemma kva oppskrifter som skal brukast neste veke (med mengde), og dette skal kunna brukast ved innkjøp av matvarer.

Dette eksamenssettet bygger på at du skal utvida eit eksisterande rammeverk. Dei fleste klassane eksisterer allereie. Dersom du har behov for å laga nokre ekstra, til dømes hjelpeklassar, så står du fritt til det. Viss du trur at kan det vera lurt å beskriva vala, sjå avsnitt om Oppgavekommentarer.md under.

## Sentrale klassar

Sentralt i oppgåvene står handtering av matvarer/ingrediensar. T.d. inneheld både oppskrifter og matlageret ein mengde av eit sett med ingrediensar. Ein ingrediens blir representert med ein **String** og mengda/talet av ingrediensen med eit desimaltal (*double*). 


*[Ingredients](Ingredients.java)*

Dette er eit grensesnitt med metodar for å lesa ut og gå gjennom eit sett ingrediensar og mengdene deira/mengde og metodar knytt til samanlikning av sett med ingrediensar. Den primære implementasjonen av **Ingredients** er **IngredientsContainer**.



*[IngredientContainer](IngredientContainer.java)*

Denne klassen er ein konkret implementasjon av **Ingredients**, med ekstra metodar for å endra (legga til og fjerne) ingrediensar. Denne kan brukast av andre klassar som treng å handtera ingrediensar.

*[Recipe](Recipe.java) og [RecipeReader.java](RecipeReader.java)*

Recipe-klassen representerer ei oppskrift med eit sett tilhøyrande ingrediensar for ei viss mengde porsjonar. Oppskrifter kan lesast inn frå fil vha. **RecipeReader*-klassen.

*[Kitchen](Kitchen.java)*

Kjøkkenet har ei oversikt over alle kjente oppskrifter og dei oppskriftene som skal brukast i vekemenyen. I tillegg har han eit lager av matvarer, som må etterfyllast når ein ny vekemeny blir lagd inn.



## Oppgavestruktur

Le Petit Chef er delt i 5 oppgåver, som er naturlege å gjera i rekkefølgje. Du bør likevel tenka på det som ein heilskap, og det er sluttresultatet som skal leverast inn. Klassane er allereie oppretta og inneheld (nokon av dei nødvendige) metodane med javadoc og *// TODO*-kommentarar som indikerer kva som må implementerast.

Her blir trinna beskrivne skissemessig, detaljar finst i [oppgåveskildringa](Oppgavebeskrivelse_NN.md). Lenkene under går til toppen av oppgåveskildringa, ikkje til dei respektive oppgåvene.

[Oppgåve 1](Oppgavebeskrivelse_NN.md) handlar om **IngredientContainer**, som implementerer **Ingredients**, **Recipe** og **RecipeReader**.

[Oppgåve 2](Oppgavebeskrivelse_NN.md) handlar om **Kitchen**. Denne inneheld eit sett med oppskrifter, eit lager med ingrediensar og neste vekes meny.

[Oppgåve 3](Oppgavebeskrivelse_NN.md) handlar om delegering, der du skal implementera ein ny metode i **Recipe*

[Oppgåve 4](Oppgavebeskrivelse_NN.md) handlar om observerbarhet, der nokon skal få beskjed når kokken har laga ferdig neste vekes meny.

[Oppgåve 5](Oppgavebeskrivelse_NN.md) handlar om ein JavaFX-app der kokken kan legga inn neste vekes meny.

Eclipse sin md-editor har faner nede til venstre for å skriva (**Markdown Source**) og éin for å sjå resultatet (**Preview**). Dersom du treng å klargjera antakelser du meiner du må gjera eller ønsker å kommentera til sensor, så kan du gjera det i md-filen [Oppgavekommentarer.md](Oppgavekommentarer.md), som vi har lenka til i avsnittet *Dine kommentarar**. Gå til seksjonen i denne oppgåva som passar til oppgåvenummeret du er i.