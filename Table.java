package rezwan;


import java.util.List;
import java.util.ArrayList;

public class Table
{
    List<List<Object>> table;

    GetClass get = new GetClass();
    SetClass set = new SetClass();
    
    
    public Table()
    {
        table = new ArrayList<List<Object>>(1);
        table.add(new ArrayList<Object>(1));
        table.get(1).add("");;
    }

    public Table( int x, int y )
    {
        table = new ArrayList<List<Object>>(x);

        for( int row = 0; row < x; row++ )
        {
            table.add(new ArrayList<Object>(y));
            for( int column = 0; column < y; column++ )
            {
                table.get(row).add("");
            }
        }
    }

    public Table( Object[][] table)
    {
        this.table = new ArrayList<List<Object>>(table.length);

        for( int row = 0, stop = table.length; row < stop; row++ )
        {
            this.table.add(new ArrayList<Object>(table[row].length));
            for( int column = 0; column < table[row].length; column++ )
            {
                this.table.get(row).add(table[row][column]);
            }
        }
    }

    public Table( List<? extends List<?>> table )
    {
        this.table = new ArrayList<List<Object>>(table.size());

        for( int row = 0, stop = table.size(); row < stop; row++ )
        {
            this.table.add(new ArrayList<Object>(table.get(row)));
        }

        filler();
    }

    public Table( ArrayList<? extends ArrayList<?>> table )
    {
        this.table = new ArrayList<List<Object>>(table.size());

        for( int row = 0, stop = table.size(); row < stop; row++ )
        {
            this.table.add(new ArrayList<Object>(table.get(row)));
        }

        filler();
    }

    public Table( Table table )
    {
        this.table = new ArrayList<List<Object>>(table.columnSize());

        for( int row = 0, stop = table.columnSize(); row < stop; row++ )
        {
            this.table.add(new ArrayList<Object>(table.get.row.asArrayList(row)));
        } 

        filler();
    }
   
    
    public void filler()
    {
        for( int row = 0, stop = columnSize(); row < stop; row++ )
        {
            if( table.get(row).size() < rowSize() )
            {
                for( int column = table.get(row).size(), end = rowSize()-1; column < end; column++ )
                    table.get(row).add("");
            }
        }
    }

    
    public int columnSize()
    {
        return table.size();
    }

    public int columnSize(int column)
    {
        List<Object> col = new ArrayList<Object>();

        for( int iterate = 0, stop = table.size(); iterate < stop; iterate++ )
            col.add(table.get(iterate).get(column));

        while( col.get(0) == "" )
            col.remove(0);

        while( col.get(col.size() - 1) == "" )
            col.remove(col.size() - 1);

        return col.size();
    }

    public int rowSize()
    {
        int size = 0;

        for( int row = 0, stop = table.size(); row < stop; row++ )
        {
            if( table.get(row).size() > size )
                size = table.get(row).size();
        }

        return size;
    }

    public int rowSize(int row)
    {
        return table.get(row).size();
    }
    
    
    public static boolean isObjectCommon( Object check )
    {
        if( check instanceof Byte || check instanceof Short || check instanceof Integer || check instanceof Long || check instanceof Float || check instanceof Double || check instanceof Boolean || check instanceof Character || check instanceof String) 
            return true;
        else
            return false;
    }   

    public static boolean isObjectCommonArray( Object check )
    {
        if( check instanceof byte[] || check instanceof short[] || check instanceof int[] || check instanceof long[] || check instanceof float[] || check instanceof double[] || check instanceof boolean[] || check instanceof char[] || check instanceof String[] ) 
            return true;
        else
            return false;
    } 
    
    public static boolean isObjectCommon2DArray( Object check )
    {
        if( check instanceof byte[][] || check instanceof short[][] || check instanceof int[][] || check instanceof long[][] || check instanceof float[][] || check instanceof double[][] || check instanceof boolean[][] || check instanceof char[][] || check instanceof String[][] ) 
            return true;
        else
            return false;
    } 
    
    public static boolean isObjectCommonList( Object input )
    {
        List<?> check;

        try
        {
            check = (List<?>)input;
        }
        catch( ClassCastException cce )
        {
            return false;
        }

        for( int iterate = 0, stop = check.size(); iterate < stop; iterate++ )
            if( !(check.get(iterate) instanceof Byte || check.get(iterate) instanceof Short || check.get(iterate) instanceof Integer || check.get(iterate) instanceof Long || check.get(iterate) instanceof Float || check.get(iterate) instanceof Double || check.get(iterate) instanceof Boolean || check.get(iterate) instanceof Character || check.get(iterate) instanceof String) ) 
                return false;    

        return true;    
    } 
    
    public static boolean isObjectCommon2DList( Object input )
    {
        List<?> takeout;
        List<List<?>> check;
        try
        {
            takeout = (List<?>)input;
            check = new ArrayList<List<?>>();
            for( int iterate = 0, stop = takeout.size(); iterate < stop; iterate++)
                check.add((List<?>)takeout.get(iterate));
        }
        catch( ClassCastException cce )
        {
            return false;
        }

        for( int iterateRow = 0, stopRow = check.size(); iterateRow < stopRow; iterateRow++ )
            for( int iterateColumn = 0, stopColumn = check.get(iterateRow).size(); iterateColumn < stopColumn; iterateColumn++)
                if( !(check.get(iterateRow).get(iterateColumn) instanceof Byte || check.get(iterateRow).get(iterateColumn) instanceof Short || check.get(iterateRow).get(iterateColumn) instanceof Integer || check.get(iterateRow).get(iterateColumn) instanceof Long || check.get(iterateRow).get(iterateColumn) instanceof Float || check.get(iterateRow).get(iterateColumn) instanceof Double || check.get(iterateRow).get(iterateColumn) instanceof Boolean || check.get(iterateRow).get(iterateColumn) instanceof Character || check.get(iterateRow).get(iterateColumn) instanceof String) ) 
                    return false;    

        return true;    
    } 
    
    public static Object[] castToCommonArray( Object input )
    {
        Object[] output = new Object[1];

        if( input instanceof byte[] )
        {
            byte[] temp = (byte[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof short[] )
        {
            short[] temp = (short[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }    
        else if( input instanceof int[] )
        {
            int[] temp = (int[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof long[] )
        {
            long[] temp = (long[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof float[] )
        {
            float[] temp = (float[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof double[] )
        {
            double[] temp = (double[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof boolean[] )
        {
            boolean[] temp = (boolean[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof char[] )
        {
            char[] temp = (char[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof String[] )
        {
            String[] temp = (String[])input;
            output = new Object[temp.length];
            for( int iterate = 0; iterate < temp.length; iterate++ )
                output[iterate] = temp[iterate];
        }
        else if( input instanceof Object[] )
        {
            output = (Object[])input;
        }
        else
        {
            output[0] = input;
        }

        return output;    
    }
    
    public static Object[][] castToCommon2DArray( Object input )
    {
        Object[][] output = new Object[1][1];

        if( input instanceof byte[][] )
        {
            byte[][] temp = (byte[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof short[][] )
        {
            short[][] temp = (short[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }    
        else if( input instanceof int[][] )
        {
            int[][] temp = (int[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof long[][] )
        {
            long[][] temp = (long[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof float[][] )
        {
            float[][] temp = (float[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof double[][] )
        {
            double[][] temp = (double[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof boolean[][] )
        {
            boolean[][] temp = (boolean[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof char[][] )
        {
            char[][] temp = (char[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else if( input instanceof String[][] )
        {
            String[][] temp = (String[][])input;
            output = new Object[temp.length][];
            for( int iterateRow = 0; iterateRow < temp.length; iterateRow++ )
            {
                output[iterateRow] = new Object[temp[iterateRow].length];
                for( int iterateColumn = 0; iterateColumn < temp[iterateRow].length; iterateColumn++)
                    output[iterateRow][iterateColumn] = temp[iterateRow][iterateColumn];
            }
        }
        else
        {
            output[0][0] = input;
        }

        return output;    
    }
    
    public static List<?> castToCommonList( Object input )
    {
        return (List<?>)input;
    }
    
    public static List<List<?>> castToCommon2DList( Object input )
    {
        List<?> takeout = (List<?>)input;
        List<List<?>> output = new ArrayList<List<?>>();
        for( int iterate = 0, stop = takeout.size(); iterate < stop; iterate++)
            output.add((List<?>)takeout.get(iterate));
        return output;
    }
    
    class GetClass
    {
        RowClass row = new RowClass();
        ColumnClass column = new ColumnClass();
        SlotClass slot = new SlotClass();
        
        public Object slot( int x, int y )
        {    
            return table.get(x).get(y);
        }
        
        class SlotClass
        {
            AsArrayClass asArray = new AsArrayClass();
            AsArrayListClass asArrayList = new AsArrayListClass();
          
            public byte asByte( int x, int y )
            {    
                return (byte)table.get(x).get(y);
            }
           
            public short asShort( int x, int y )
            {    
                return (short)table.get(x).get(y);
            }
           
            public int asInt( int x, int y )
            {    
                return (int)table.get(x).get(y);
            }
           
            public long asLong( int x, int y )
            {    
                return (long)table.get(x).get(y);
            }
           
            public float asFloat( int x, int y )
            {    
                return (float)table.get(x).get(y);
            }
           
            public double asDouble( int x, int y )
            {    
                return (double)table.get(x).get(y);
            }
           
            public boolean asBoolean( int x, int y )
            {    
                return (boolean)table.get(x).get(y);
            }
           
            public char asChar( int x, int y )
            {    
                return (char)table.get(x).get(y);
            }
           
            public String asString( int x, int y )
            {    
                return (String)table.get(x).get(y);
            }
            
            
            public ArrayList<ArrayList<Object>> asArrayList( int x1, int y1, int x2, int y2 )
            {
                ArrayList<ArrayList<Object>> output = new ArrayList<ArrayList<Object>>(x2 - x1 + 1);
                
                for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                {
                    output.add(new ArrayList<Object>(y2 - y1 + 1));
                    for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                    {
                        output.get(iterateRow).add(table.get(iterateRow).get(iterateColumn));
                    }
                }       
                return output;
            }
            
            class AsArrayListClass
            {
                public ArrayList<ArrayList<Byte>> asByte( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Byte>> output = new ArrayList<ArrayList<Byte>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Byte>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((byte)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Short>> asShort( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Short>> output = new ArrayList<ArrayList<Short>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Short>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((short)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Integer>> asInt( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Integer>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((int)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Long>> asLong( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Long>> output = new ArrayList<ArrayList<Long>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Long>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((long)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Float>> asFloat( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Float>> output = new ArrayList<ArrayList<Float>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Float>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((float)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Double>> asDouble( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Double>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((double)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Boolean>> asBoolean( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Boolean>> output = new ArrayList<ArrayList<Boolean>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Boolean>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((boolean)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<Character>> asChar( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<Character>> output = new ArrayList<ArrayList<Character>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<Character>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((char)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
                
                public ArrayList<ArrayList<String>> asString( int x1, int y1, int x2, int y2 )
                {
                    ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>(x2 - x1 + 1);
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    {
                        output.add(new ArrayList<String>(y2 - y1 + 1));
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        {
                            output.get(iterateRow).add((String)table.get(iterateRow).get(iterateColumn));
                        }
                    }       
                    return output;
                }
            }
            
            public Object[][] asArray( int x1, int y1, int x2, int y2 )
            {
                Object[][] output = new Object[x2 - x1 + 1][y2 - y1 + 1];
                
                for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                    for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                        output[iterateRow][iterateColumn] = table.get(iterateRow).get(iterateColumn);
                        
                return output;
            }
            
            class AsArrayClass
            {
                public byte[][] asByte( int x1, int y1, int x2, int y2 )
                {
                    byte[][] output = new byte[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (byte)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public short[][] asShort( int x1, int y1, int x2, int y2 )
                {
                    short[][] output = new short[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (short)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public int[][] asInt( int x1, int y1, int x2, int y2 )
                {
                    int[][] output = new int[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (int)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public long[][] asLong( int x1, int y1, int x2, int y2 )
                {
                    long[][] output = new long[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (long)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public float[][] asFloat( int x1, int y1, int x2, int y2 )
                {
                    float[][] output = new float[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (float)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public double[][] asDouble( int x1, int y1, int x2, int y2 )
                {
                    double[][] output = new double[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (double)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public boolean[][] asBoolean( int x1, int y1, int x2, int y2 )
                {
                    boolean[][] output = new boolean[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (boolean)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public char[][] asChar( int x1, int y1, int x2, int y2 )
                {
                    char[][] output = new char[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (char)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
                
                public String[][] asString( int x1, int y1, int x2, int y2 )
                {
                    String[][] output = new String[x2 - x1 + 1][y2 - y1 + 1];
                    
                    for( int iterateRow = x1, stopRow = x2 + 1; iterateRow < stopRow; iterateRow++ )
                        for( int iterateColumn = y1, stopColumn = y2 + 1; iterateColumn < stopColumn; iterateColumn++)
                            output[iterateRow][iterateColumn] = (String)table.get(iterateRow).get(iterateColumn);
                            
                    return output;
                }
            }
        }
        
        
        
        class RowClass
        {
            AsArrayListClass asArrayList = new AsArrayListClass();
            AsArrayClass asArray = new AsArrayClass();
            
            public ArrayList<Object> asArrayList( int x )
            {
                return (ArrayList<Object>)table.get(x);
            }
            
            public ArrayList<Object> asArrayList( int x, int y1, int y2 )
            {
                ArrayList<Object> output = new ArrayList<Object>(y2 - y1 + 1);
                
                for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                    output.add( table.get(x).get(iterate) );
                
                return output;
            }
            
            class AsArrayListClass
            {
                public ArrayList<Byte> asByte( int x )
                {
                    ArrayList<Byte> output = new ArrayList<Byte>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (byte)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Byte> asByte( int x, int y1, int y2 )
                {
                    ArrayList<Byte> output = new ArrayList<Byte>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (byte)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Short> asShort( int x )
                {
                    ArrayList<Short> output = new ArrayList<Short>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (short)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Short> asShort( int x, int y1, int y2 )
                {
                    ArrayList<Short> output = new ArrayList<Short>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (short)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Integer> asInt( int x )
                {
                    ArrayList<Integer> output = new ArrayList<Integer>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (int)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Integer> asInt( int x, int y1, int y2 )
                {
                    ArrayList<Integer> output = new ArrayList<Integer>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (int)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Long> asLong( int x )
                {
                    ArrayList<Long> output = new ArrayList<Long>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (long)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Long> asLong( int x, int y1, int y2 )
                {
                    ArrayList<Long> output = new ArrayList<Long>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (long)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Float> asFloat( int x )
                {
                    ArrayList<Float> output = new ArrayList<Float>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (float)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Float> asFloat( int x, int y1, int y2 )
                {
                    ArrayList<Float> output = new ArrayList<Float>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (float)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Double> asDouble( int x )
                {
                    ArrayList<Double> output = new ArrayList<Double>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (double)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Double> asDouble( int x, int y1, int y2 )
                {
                    ArrayList<Double> output = new ArrayList<Double>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (double)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Boolean> asBoolean( int x )
                {
                    ArrayList<Boolean> output = new ArrayList<Boolean>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (boolean)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Boolean> asBoolean( int x, int y1, int y2 )
                {
                    ArrayList<Boolean> output = new ArrayList<Boolean>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (boolean)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Character> asCharacter( int x )
                {
                    ArrayList<Character> output = new ArrayList<Character>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (char)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<Character> asCharacter( int x, int y1, int y2 )
                {
                    ArrayList<Character> output = new ArrayList<Character>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (char)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<String> asString( int x )
                {
                    ArrayList<String> output = new ArrayList<String>(rowSize(x));
                    
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output.add( (String)table.get(x).get(iterate) );
                    
                    return output;
                }
                
                public ArrayList<String> asString( int x, int y1, int y2 )
                {
                    ArrayList<String> output = new ArrayList<String>(y2 - y1 + 1);
                    
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output.add( (String)table.get(x).get(iterate) );
                    
                    return output;
                }
            }
            
            public Object[] asArray( int x )
            {
                Object[] output = new Object[rowSize(x)];
        
                for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                    output[iterate] = table.get(x).get(iterate);
        
                return output;
            }
            
            public Object[] asArray( int x, int y1, int y2 )
            {
                Object[] output = new Object[y2 - y1 + 1];
        
                for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                    output[iterate] = table.get(x).get(iterate);
        
                return output;
            }
            
            class AsArrayClass
            {
                public byte[] asByte( int x )
                {       
                    byte[] output = new byte[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (byte)table.get(x).get(iterate);
            
                    return output;
                }
                
                public byte[] asByte( int x, int y1, int y2 )
                {       
                    byte[] output = new byte[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (byte)table.get(x).get(iterate);
            
                    return output;
                }
                
                public short[] asShort( int x )
                {       
                    short[] output = new short[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (short)table.get(x).get(iterate);
            
                    return output;
                }
                
                public short[] asShort( int x, int y1, int y2 )
                {       
                    short[] output = new short[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (short)table.get(x).get(iterate);
            
                    return output;
                }
                
                public int[] asInt( int x )
                {       
                    int[] output = new int[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (int)table.get(x).get(iterate);
            
                    return output;
                }
            
                public int[] asInt( int x, int y1, int y2 )
                {       
                    int[] output = new int[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (int)table.get(x).get(iterate);
            
                    return output;
                }
                
                public long[] asLong( int x )
                {       
                    long[] output = new long[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (long)table.get(x).get(iterate);
            
                    return output;
                }
                
                public long[] asLong( int x, int y1, int y2 )
                {       
                    long[] output = new long[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (long)table.get(x).get(iterate);
            
                    return output;
                }
                
                public float[] asFloat( int x )
                {       
                    float[] output = new float[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (float)table.get(x).get(iterate);
            
                    return output;
                }
                
                public float[] asFloat( int x, int y1, int y2 )
                {       
                    float[] output = new float[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (float)table.get(x).get(iterate);
            
                    return output;
                }
                
                public double[] asDouble( int x )
                {       
                    double[] output = new double[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (double)table.get(x).get(iterate);
            
                    return output;
                }
                
                public double[] asDouble( int x, int y1, int y2 )
                {       
                    double[] output = new double[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (double)table.get(x).get(iterate);
            
                    return output;
                }
                
                public boolean[] asBoolean( int x )
                {       
                    boolean[] output = new boolean[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (boolean)table.get(x).get(iterate);
            
                    return output;
                }
                
                public boolean[] asBoolean( int x, int y1, int y2 )
                {       
                    boolean[] output = new boolean[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (boolean)table.get(x).get(iterate);
            
                    return output;
                }
                
                public char[] asChar( int x )
                {       
                    char[] output = new char[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (char)table.get(x).get(iterate);
            
                    return output;
                }
            
                public char[] asChar( int x, int y1, int y2 )
                {       
                    char[] output = new char[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (char)table.get(x).get(iterate);
            
                    return output;
                }
                    
                public String[] asString( int x )
                {       
                    String[] output = new String[rowSize(x)];
            
                    for( int iterate = 0, stop = rowSize(x); iterate < stop; iterate++ )
                        output[iterate] = (String)table.get(x).get(iterate);
            
                    return output;
                }
                
                public String[] asString( int x, int y1, int y2 )
                {       
                    String[] output = new String[y2 - y1 + 1];
            
                    for( int iterate = y1, stop = y2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (String)table.get(x).get(iterate);
            
                    return output;
                }
            }
        }
        
        
        class ColumnClass
        {
            AsArrayListClass asArrayList = new AsArrayListClass();
            AsArrayClass asArray = new AsArrayClass();
            
            public ArrayList<Object> asArrayList( int y )
            {
                return (ArrayList<Object>)table.get(y);
            }
            
            public ArrayList<Object> asList( int y, int x1, int x2 )
            {
                ArrayList<Object> output = new ArrayList<Object>(x2 - x1 + 1);
                
                for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                    output.add( (byte)table.get(iterate).get(y) );
                
                return output;
            }
            
            class AsArrayListClass
            {
                public ArrayList<Byte> asByte( int y )
                {
                    ArrayList<Byte> output = new ArrayList<Byte>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (byte)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Byte> asByte( int y, int x1, int x2 )
                {
                    ArrayList<Byte> output = new ArrayList<Byte>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (byte)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Short> asShort( int y )
                {
                    ArrayList<Short> output = new ArrayList<Short>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (short)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Short> asShort( int y, int x1, int x2 )
                {
                    ArrayList<Short> output = new ArrayList<Short>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (short)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Integer> asInt( int y )
                {
                    ArrayList<Integer> output = new ArrayList<Integer>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (int)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Integer> asInt( int y, int x1, int x2 )
                {
                    ArrayList<Integer> output = new ArrayList<Integer>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (int)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Long> asLong( int y )
                {
                    ArrayList<Long> output = new ArrayList<Long>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (long)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Long> asLong( int y, int x1, int x2 )
                {
                    ArrayList<Long> output = new ArrayList<Long>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (long)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Float> asFloat( int y )
                {
                    ArrayList<Float> output = new ArrayList<Float>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (float)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Float> asFloat( int y, int x1, int x2 )
                {
                    ArrayList<Float> output = new ArrayList<Float>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (float)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Double> asDouble( int y )
                {
                    ArrayList<Double> output = new ArrayList<Double>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (double)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Double> asDouble( int y, int x1, int x2 )
                {
                    ArrayList<Double> output = new ArrayList<Double>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (double)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Boolean> asBoolean( int y )
                {
                    ArrayList<Boolean> output = new ArrayList<Boolean>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (boolean)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Boolean> asBoolean( int y, int x1, int x2 )
                {
                    ArrayList<Boolean> output = new ArrayList<Boolean>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (boolean)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Character> asChar( int y )
                {
                    ArrayList<Character> output = new ArrayList<Character>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (char)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<Character> asChar( int y, int x1, int x2 )
                {
                    ArrayList<Character> output = new ArrayList<Character>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (char)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<String> asString( int y )
                {
                    ArrayList<String> output = new ArrayList<String>(columnSize(y));
                    
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output.add( (String)table.get(iterate).get(y) );
                    
                    return output;
                }
                
                public ArrayList<String> asString( int y, int x1, int x2 )
                {
                    ArrayList<String> output = new ArrayList<String>(x2 - x1 + 1);
                    
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output.add( (String)table.get(iterate).get(y) );
                    
                    return output;
                }
            }
            
            public Object[] asArray( int y )
            {
                Object[] output = new Object[columnSize(y)];
        
                for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                    output[iterate] = table.get(iterate).get(y);
        
                return output;
            }
            
            public Object[] asArray( int y, int x1, int x2 )
            {
                Object[] output = new Object[x2 - x1 + 1];
        
                for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                    output[iterate] = table.get(iterate).get(y);
        
                return output;
            }
            
            class AsArrayClass
            {
                public byte[] asByte( int y )
                {       
                    byte[] output = new byte[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (byte)table.get(iterate).get(y);
            
                    return output;
                }
                
                public byte[] asByte( int y, int x1, int x2 )
                {       
                    byte[] output = new byte[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (byte)table.get(iterate).get(y);
            
                    return output;
                }
                
                public short[] asShort( int y )
                {       
                    short[] output = new short[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (short)table.get(iterate).get(y);
            
                    return output;
                }
            
                public short[] asShort( int y, int x1, int x2 )
                {       
                    short[] output = new short[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (short)table.get(iterate).get(y);
            
                    return output;
                }
                
                public int[] asInt( int y )
                {       
                    int[] output = new int[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (int)table.get(iterate).get(y);
            
                    return output;
                }
            
                public int[] asInt( int y, int x1, int x2 )
                {       
                    int[] output = new int[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (int)table.get(iterate).get(y);
            
                    return output;
                }
                
                public long[] asLong( int y )
                {       
                    long[] output = new long[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (long)table.get(iterate).get(y);
            
                    return output;
                }
            
                public long[] asLong( int y, int x1, int x2 )
                {       
                    long[] output = new long[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (long)table.get(iterate).get(y);
            
                    return output;
                }
                
                public float[] asFloat( int y )
                {       
                    float[] output = new float[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (float)table.get(iterate).get(y);
            
                    return output;
                }
            
                public float[] asFloat( int y, int x1, int x2 )
                {       
                    float[] output = new float[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (float)table.get(iterate).get(y);
            
                    return output;
                }
                
                public double[] asDouble( int y )
                {       
                    double[] output = new double[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (double)table.get(iterate).get(y);
            
                    return output;
                }
            
                public double[] asDouble( int y, int x1, int x2 )
                {       
                    double[] output = new double[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (double)table.get(iterate).get(y);
            
                    return output;
                }
                
                public boolean[] asBoolean( int y )
                {       
                    boolean[] output = new boolean[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (boolean)table.get(iterate).get(y);
            
                    return output;
                }
            
                public boolean[] asBoolean( int y, int x1, int x2 )
                {       
                    boolean[] output = new boolean[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (boolean)table.get(iterate).get(y);
            
                    return output;
                }
                
                public char[] asChar( int y )
                {       
                    char[] output = new char[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (char)table.get(iterate).get(y);
            
                    return output;
                }
            
                public char[] asChar( int y, int x1, int x2 )
                {       
                    char[] output = new char[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (char)table.get(iterate).get(y);
            
                    return output;
                }
                
                public String[] asString( int y )
                {       
                    String[] output = new String[columnSize(y)];
            
                    for( int iterate = 0, stop = columnSize(y); iterate < stop; iterate++ )
                        output[iterate] = (String)table.get(iterate).get(y);
            
                    return output;
                }
                
                public String[] asString( int y, int x1, int x2 )
                {       
                    String[] output = new String[x2 - x1 + 1];
            
                    for( int iterate = x1, stop = x2 + 1; iterate < stop; iterate++ )
                        output[iterate] = (String)table.get(iterate).get(y);
            
                    return output;
                }
            }
        }
    }
    
    class SetClass
    {
        public void slot( int x, int y, Object... input )
        {
            if( input.length == 1 && !input[0].getClass().isArray() && isObjectCommon(input[0]))
            {
                table.get(x).set( y, input[0] );
            }
            else if( input.length == 1 && isObjectCommon2DArray(input[0]) )
            {
                Object[][] array = castToCommon2DArray(input[0]); 
                
                for( int row = 0, horizontal = x; row < array.length; row++, horizontal++ )
                    for( int column = 0, vertical = y; column < array[row].length; column++, vertical++ )
                        table.get(horizontal).set( vertical, array[row][column] );
            }
            else if( input.length == 1 && isObjectCommon2DList(input[0]) )
            {
                List<List<?>> array = castToCommon2DList(input[0]); 
                
                for( int row = 0, horizontal = x, stopRow = array.size(); row < stopRow ; row++, horizontal++ )
                    for( int column = 0, vertical = y, stopColumn = array.get(row).size(); column < stopColumn; column++, vertical++ )
                        table.get(horizontal).set( vertical, array.get(row).get(column) );
            }
            else if( input.length > 1 )
            {
                for( int iterate = 0; iterate < input.length; iterate++ )
                    if( !( isObjectCommonArray(input[iterate]) || isObjectCommonList(input[iterate]) ) )
                        return;
                        
                for( int row = 0, horizontal = x; row < input.length; row++, horizontal++ )
                {
                    if(isObjectCommonArray(input[row]))
                    {
                        Object[] array = castToCommonArray(input[row]);
                        for( int column = 0, vertical = y; column < array.length; column++, vertical++ )
                            table.get(horizontal).set( vertical, array[column] );
                    }
                    else if(isObjectCommonList(input[row]))
                    {
                        List<?> array = castToCommonList(input[row]);
                        for( int column = 0, vertical = y, stopColumn = array.size(); column < stopColumn; column++, vertical++ )
                            table.get(horizontal).set( vertical, array.get(column) );
                    }
                }
            }
        }
        
        public void row( int x, Object... input )
        {   
            int length;
            
            if( input.length == 1 && isObjectCommonArray(input[0]) )
            {
                Object[] array = castToCommonArray(input[0]);
                for( int column = 0; column < array.length; column++)
                    table.get(x).set( column, array[column] );
                length = array.length;
            }
            else if( input.length == 1 && isObjectCommonList(input[0]) )
            {
                List<?> array = castToCommonList(input[0]);
                for( int column = 0, stopColumn = array.size(); column < stopColumn; column++ )
                    table.get(x).set( column, array.get(column) );
                length = array.size();
            }
            else if( input.length > 1 )
            {
                for( int iterate = 0; iterate < input.length; iterate++ )
                    if( !isObjectCommon(input[iterate]) )
                        return;
                
                for( int column = 0; column < input.length; column++)
                    table.get(x).set( column, input[column] );
                
                length = input.length;
            }
            else
            {
                length = table.get(x).size();
            }
            
            for( int column = length, stop = table.get(x).size(); column < stop; column++ )
                table.get(x).set( column, "" );
        }
        
        public void column( int y, Object... input )
        {   
            int length;
            
            if( input.length == 1 && isObjectCommonArray(input[0]) )
            {
                Object[] array = castToCommonArray(input[0]);
                for( int row = 0; row < array.length; row++)
                    table.get(row).set( y, array[row] );
                length = array.length;
            }
            else if( input.length == 1 && isObjectCommonList(input[0]) )
            {
                List<?> array = castToCommonList(input[0]);
                for( int row = 0, stopRow = array.size(); row < stopRow; row++ )
                    table.get(row).set( y, array.get(row) );
                length = array.size();
            }
            else if( input.length > 1 )
            {
                for( int iterate = 0; iterate < input.length; iterate++ )
                    if( !isObjectCommon(input[iterate]) )
                        return;
                
                for( int row = 0; row < input.length; row++)
                    table.get(row).set( y, input[row] );
                
                length = input.length;
            }
            else
            {
                length = table.size();
            }
            
            for( int row = length, stop = table.size(); row < stop; row++ )
                table.get(row).set( y, "" );
        }
    }
    
    public String toString()
    {
        String output = "";
        
        for( int row = 0, stopRow = table.size(); row < stopRow; row++)
        {
            for( int column = 0, stopColumn = table.get(row).size(); column < stopColumn; column++)
            {
                output += " " + table.get(row).get(column);
            }
            System.out.println();
        }
        
        return output;
    }
}

