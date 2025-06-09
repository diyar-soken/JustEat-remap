export interface Ordine {
  id?: number;          // opzionale, identificativo dell'ordine
  data: string;         // data dell'ordine (preferibilmente in formato ISO string)
  cliente: string;      // codice fiscale del cliente (relazione)
  ristorante: string;   // partita IVA del ristorante (relazione)
  totale: number;       // importo totale dell'ordine
}
