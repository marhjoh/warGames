Jeg lagde bare sekvens diagram av de diagrammene jeg synes er de viktigste for programmet. 

**attack**
Jeg tar imot terrain som parameter av datatype Character i attack-metoden til Unit. Dette gjør at de abstrakte metodene til Unit også tar imot terrain som parameter. For å finne ut hvor mye health attack metoden skal fjerne sjekker den attackeren sin attack bonus og defenderen sin resist bonus (gjennom aksessorere). 

![sequence_1](uploads/5c20cceba46d19b62ee3e0eb8aa289eb/sequence_1.png)

**resetBattle** 
Dette er reset metoden som tillater funksjonaliteten "å ikke måtte oppgi fillokasjon på nytt". Måten jeg løste det på var gjennom å lage to identiske hærer når jeg leser hærene. Dersom brukeren skulle ønske å resette slaget hentes de dupliserte hærene, og erstatter da de hærene som ble simulert. Etter dette blir det laget en kopi av disse igjen, slik at hvis man skulle ønske å kjøre en ny simulering følger samme prosedyre. 
![sequence_2](uploads/ae2d0ecc281e17db029cd34d0b1a7fc9/sequence_2.png)
![sequence_3](uploads/d614326ecdef9d05bf40cfab8ae8ec2a/sequence_3.png)

**saveArmy**
Etter knappen blir trykket på lages en ny hær, og alle units i den observable listen blir lagt til i hæren. Etter dette blir en filechooser opprettet, og navnet på filen som skal lagres blir satt lik hæren sitt navn. Hæren blir så skrevet om til en fil gjennom ArmyFileHandler sin writeArmyCsv metode. Til slutt blir brukeren informert at filen er lagret gjennom en confirmationPopUp.

![sequence_4](uploads/2114e5fa034d69a3946cc1c1ad2a4440/sequence_4.png)

**loadArmy**
Først blir en filechooser opprettet, denne leser den valgte filen dersom den ikke er lik null. Den setter så hæren som allerede er implementert lik unitList-en som blir lest. Etter dette gjør den det samme med navnet på hæren. Videre, setter den verdiene i table view-en lik listen til hæren. Dette gjør også neste metode, men denne har jeg implementert grunnet den ikke alltid har klart å endre verdier. Den nestsiste metoden henter antall av hver enhetstype og totalt antall av units i hæren og viser tekst av totalene. Dersom en av hærene skulle være tomme blir den hærens verdier byttet ut med "xxx". Etter dette dupliserer jeg den nyopprettede hæren. Her bruker jeg «Creational» designmønster i form av Factory. Denne blir også kjørt før hver simulering.

![sequence_5](uploads/19f225cacac53d9f543665bbee4ea70e/sequence_5.png)
![sequence_6](uploads/70eca3181e96d955953c17f1f8240346/sequence_6.png)
![sequence_7](uploads/38ce32870f21ac3efbaf2e03581141f2/sequence_7.png)