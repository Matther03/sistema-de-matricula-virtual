// Libraries
import { 
    Checkbox,
    FormControlLabel 
} from '@mui/material';

const CustomCheckbox = ({ 
    label,
    checked,
    handleChange,
    name 
}) => {
    return (
        <FormControlLabel
            control={
                <Checkbox 
                    checked={checked && checked} 
                    onChange={handleChange && handleChange} 
                    name={name && name}/>
            }
            label={label && label}/>
    )
}

export default CustomCheckbox;