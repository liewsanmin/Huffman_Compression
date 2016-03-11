if(!binary.isEmpty())
        {
            if(binary.length() % MAX_BYTE_SIZE_IN_BIT == 0)
                bytes = new byte[binary.length() / MAX_BYTE_SIZE_IN_BIT];
            else
                bytes = new byte[binary.length() / MAX_BYTE_SIZE_IN_BIT + 1];
            
            //every eight bit of binary put in the byte array
            for(int i = 0; i < bytes.length; i++)
            {
                String eightBinary;
                int lengthDiff = (i + 1) * MAX_BYTE_SIZE_IN_BIT - 
                                 binary.length();
                if(lengthDiff > 0)
                {
                    for(int z = 0; z < lengthDiff; z++)
                    {
                        binary += "0";
                    }
                    eightBinary = binary.substring(i * MAX_BYTE_SIZE_IN_BIT);
                    byte currentByte = (byte) Integer.parseInt(eightBinary, 2);
                    bytes[i] = currentByte;
                }
                else
                {
                    eightBinary = binary.substring(i * MAX_BYTE_SIZE_IN_BIT, 
                                  (i + 1) * MAX_BYTE_SIZE_IN_BIT);
                    byte currentByte = (byte)Integer.parseInt(eightBinary, 2);
                    bytes[i] = currentByte;
                }
            }      
            try
            {
                //create the file with replace extention
                hufFile = new File(fileName.replace(".txt", ".huf"));
                hufFile.createNewFile();
                try 
                {
                    FileOutputStream f = new FileOutputStream(hufFile);
                    f.write(bytes);
                    f.close();
                }
                catch(IOException ex){}
            }
            catch(IOException ex){}
        }