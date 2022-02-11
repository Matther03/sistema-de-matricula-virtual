import {  
    StyledContainerTable, 
    StyledCaptionTable, 
    StyledTableRow,
    StyledTableCell
} from './styles';
import { 
    Table, 
    TableRow, 
    TableBody, 
    TableHead 
} from '@mui/material';

const CustomDataTable = ({ 
    className, 
    caption, 
    fields, 
    rows, 
    width 
}) => {
  return (
    <StyledContainerTable className={className} width={width || '98%'}>
      <Table sx={{ minWidth: 500 }}>
        {caption && <StyledCaptionTable>{caption}</StyledCaptionTable>}
        <TableHead>
            <TableRow>
                {fields && fields.map((field, idx) => (
                    <StyledTableCell key={idx}>{field}</StyledTableCell>
                ))}
            </TableRow>
        </TableHead>
        <TableBody>
            {rows && rows.map((row, idx) => (
                <StyledTableRow key={idx}>
                    {Object.values(row).map((value, idx) => (
                        <StyledTableCell key={idx}>{value}</StyledTableCell>                        
                    ))}
                </StyledTableRow>
            ))}
        </TableBody>
      </Table>
    </StyledContainerTable>
  );
}

export default CustomDataTable;