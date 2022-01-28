import { StyledTextField } from './styles';

const CustomTextField = (props) => {
    return (
        <StyledTextField 
            {...props}
            variant="filled"/>
    );
}

export default CustomTextField;