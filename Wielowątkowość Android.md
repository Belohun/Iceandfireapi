## AsyncTask

AsyncTask jest definiowany przez 3 parametry
1. Params - wysyłane do zadania po wykonaniu - doingBackground
2. Progress - rodzaj jednostek postępu opublikowanych podczas obliczeń w tle - onProgressUpdate
3. Result - typ wyniku obliczenia w tle - onPostExecute

zadanie można anulować w każdym momencie 
    cancel(boolean)
    isCancelled()

statusy AsyncTask

Statusy AsyncTasków:
    Pending
    InProgress
    Cancelled
    Finished

AsyncTask musi zostać załadowana w wątkuinterfejsu użytkownika
instancja utworzona w wątku interfejsuużytkownika
execute(Params...) wywoływać w wątkuinterfejsu użytkownika
niektórych metod nie można wykonywać manualnie

Klasy zagnieżdżone
Pola
Metody publiczne
Metody chronione

NetworkOnMainThreadException

klasa dziedzicząca po :AsyncTask

AsyncTaski są wykonywane w jednym zbiorczym wątku - po prostu tyle, że nie jest to wątek główny

## Korutyny

Coroutine - współprogram
wykonywanie A i przenoszenie wykonywania do innego B

Concurrency design pattern

Wzorzec projektowy do pisania asynchronicznego kodu

instancja klasy Job

Cykl życia obiektów Job, cykl życia korutyn

*Lightweight thread*

równoległość jest praktycznie nieograniczona

- Dispatchers.
    - IO
    - Main
    - Default
    - Unconfined
    
    Mogą być wykonywane w withContext