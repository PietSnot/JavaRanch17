/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Piet
 */
public class CareyBrown {
    
}

class StringWrap
{
    public static void main( String[] args )
    {
        String string = "123 567891123456789212345678931234567894 12   123456789212345678931234567894  1234567  8901 23";;
        List<String>      list = wrap( string, 40 );
        for( String s : list )
            System.out.println( "\"" + s + "\"" );
    }
     
    public static List<String> wrap( String s, int width )
    {
        List<String>  list = new ArrayList<>();
        if( s == null || s.isEmpty() )
            return list;
         
        while( s.length() > width )
        {
            char            c;
            int             end = width;
             
            // will split on white space or special characters
            while( --end > 0 &&
                    ( Character.isLetter( (c = s.charAt( end )) )
                    || Character.isDigit( c )
                    || c == '_' ) )
                ;
 
            if( end == 0 )
                end = width;
            else
                end++;
 
            list.add( /*trimTrailingWhiteSpace*/( s.substring( 0, end ) ) );
 
            s = end >= s.length() ? "" : s.substring( end );
        }
         
        if( s.length() > 0 )
            list.add( s );
 
        return list;
    }
 
    public static String trimTrailingWhiteSpace( String s )
    {
        if( s == null )
            return s;
        int             i = s.length();
        while( --i > 0 && Character.isWhitespace( s.charAt( i ) ) )
            ;
        return i == 0 ? "" : s.substring( 0, i+1 );
    }
}
