import java.util.Comparator;

/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 6        Summer 2020      *
 *                                                              *
 *  Class Name:  MileageComparator                              *
 *                                                              *
 *  Purpose: used for sorting destination objects using the     *
 *      normal miles.                                           *
 *       -No Changes made.                                      *
 ****************************************************************/
public class MileageComparator implements Comparator<Destination>
{
    @Override
    public int compare(Destination d1, Destination d2){
        return (d2.getNormalMiles() - d1.getNormalMiles());
    }
}
