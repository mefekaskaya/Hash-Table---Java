# Hash-Table---Java
implementation an extendible hashing to index words of a document
reads the document, split it word by word, and index each word to hash table.
The number of occurrence of each word also be stored as count value.
The initial table indexes a given key according to the last 8 bits (initial global depth and local depths will be 8).
Every slot of the table points a bucket. The bucket size is 10.
When hash table needs to resize, the new table size must be doubled to index words by using one more bit (global depth+1). 
The bucket size won’t change. E.g., After the first resize operation, the table indexes according to the last 9 bits.
After the second resize, it should index according to 10 bits etc.
When a word is searched in the hash table; key, count, and index of the word be printed.
(Global and local depths also be printed)
